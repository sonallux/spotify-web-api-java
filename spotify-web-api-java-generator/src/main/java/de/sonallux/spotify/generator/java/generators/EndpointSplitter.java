package de.sonallux.spotify.generator.java.generators;

import de.sonallux.spotify.generator.java.GeneratorException;
import de.sonallux.spotify.generator.java.model.ApiEndpoint;
import de.sonallux.spotify.generator.java.model.SpotifyWebApi;

import java.util.List;

public class EndpointSplitter {
    public static void splitEndpoints(SpotifyWebApi spotifyWebApi) {
        var category = spotifyWebApi.getCategory("Playlists");
        var endpoint = category.getEndpointFromId("reorder-or-replace-playlists-tracks");

        if (!isValidReorderOrReplaceEndpoint(endpoint)) {
            throw new GeneratorException("Can not split reorder-or-replace-playlist-tracks endpoint, because it has changed!");
        }

        var reorderEndpoint = new ApiEndpoint(
            "reorder-playlists-tracks",
            "Reorder Playlist Items",
            "Reorder items in a playlist",
            endpoint.getPath(),
            endpoint.getHttpMethod(),
            endpoint.getResponseType(),
            endpoint.getResponseDescription(),
            endpoint.getScopes(),
            false
        );
        reorderEndpoint.addPathParameter(endpoint.getRequiredPathParameters().getFirst(), true);
        endpoint.getOptionalBodyParameters().stream()
                .filter(param -> List.of("range_start", "insert_before", "range_length", "snapshot_id").contains(param.getName()))
                .forEach(param -> reorderEndpoint.addBodyParameter(param, List.of("range_start", "insert_before").contains(param.getName())));

        var replaceEndpoint = new ApiEndpoint(
            "replace-playlists-tracks",
            "Replace Playlist Items",
            "Replacing items in a playlist will overwrite its existing items. This operation can be used for replacing or clearing items in a playlist.",
            endpoint.getPath(),
            endpoint.getHttpMethod(),
            endpoint.getResponseType(),
            endpoint.getResponseDescription(),
            endpoint.getScopes(),
            false
        );
        replaceEndpoint.addPathParameter(endpoint.getRequiredPathParameters().getFirst(), true);
        endpoint.getOptionalQueryParameters().stream()
                .filter(param -> "uris".equals(param.getName()))
                .forEach(param -> replaceEndpoint.addQueryParameter(param, false));
        endpoint.getOptionalBodyParameters().stream()
                .filter(param -> "uris".equals(param.getName()))
                .forEach(param -> replaceEndpoint.addBodyParameter(param, false));

        category.removeEndpoint(endpoint);
        category.addEndpoint(reorderEndpoint);
        category.addEndpoint(replaceEndpoint);
    }

    private static boolean isValidReorderOrReplaceEndpoint(ApiEndpoint endpoint) {
        var expectedDescription = """
                Either reorder or replace items in a playlist depending on the request's parameters.
                To reorder items, include `range_start`, `insert_before`, `range_length` and `snapshot_id` in the request's body.
                To replace items, include `uris` as either a query parameter or in the request's body.
                Replacing items in a playlist will overwrite its existing items. This operation can be used for replacing or clearing items in a playlist.
                <br/>
                **Note**: Replace and reorder are mutually exclusive operations which share the same endpoint, but have different parameters.
                These operations can't be applied together in a single request.
                """;
        return "Update Playlist Items".equals(endpoint.getName()) &&
                expectedDescription.equals(endpoint.getDescription()) &&
                "/playlists/{playlist_id}/tracks".equals(endpoint.getPath()) &&
                "PUT".equals(endpoint.getHttpMethod()) &&
                "PlaylistSnapshotId".equals(endpoint.getResponseType()) &&
                "A snapshot ID for the playlist".equals(endpoint.getResponseDescription()) &&
                endpoint.getScopes().size() == 2 &&
                endpoint.getRequiredPathParameters().size() == 1 &&
                endpoint.getRequiredQueryParameters().size() == 0 &&
                endpoint.getRequiredBodyParameters().size() == 0 &&
                endpoint.getOptionalPathParameters().size() == 0 &&
                endpoint.getOptionalQueryParameters().size() == 1 &&
                endpoint.getOptionalBodyParameters().size() == 5 &&
                endpoint.getRawBodyParameter() == null;
    }
}

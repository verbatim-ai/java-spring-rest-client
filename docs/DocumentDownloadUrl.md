

# DocumentDownloadUrl

Presigned URL granting direct client download access to the archived document. The content is served by the storage backend (S3), not by this server.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**downloadUrl** | **String** | Presigned URL to GET the document content. Single-use, time-limited. |  [optional] |
|**expiresAt** | **OffsetDateTime** | Wall-clock expiration of &#x60;downloadUrl&#x60; (ISO-8601, UTC). After this, a fresh request is required. |  [optional] |
|**filename** | **String** | Original filename of the document. The client can use it for the local save name. |  [optional] |
|**contentType** | **String** | MIME content type of the document. |  [optional] |




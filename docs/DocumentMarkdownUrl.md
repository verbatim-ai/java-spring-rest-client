

# DocumentMarkdownUrl

Presigned URL granting direct client GET access to the Markdown conversion of a document. The content is served by the storage backend (S3), not by this server.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**url** | **String** | Presigned URL to GET the Markdown conversion (&#x60;text/markdown&#x60;, UTF-8). Time-limited: anyone holding it can read the file until &#x60;expiresAt&#x60;, without a token. |  |
|**timestamp** | **OffsetDateTime** | When &#x60;url&#x60; was issued (ISO-8601, UTC). |  |
|**expiresAt** | **OffsetDateTime** | Wall-clock expiration of &#x60;url&#x60; (ISO-8601, UTC). After this, a fresh request is required. |  |




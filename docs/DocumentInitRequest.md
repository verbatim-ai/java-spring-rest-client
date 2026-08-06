

# DocumentInitRequest

Body of POST /v1/doc/init. Declares a document and requests a presigned PUT URL for direct-to-storage upload.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**corpusId** | **UUID** | ID of the corpus the document will be ingested into. |  |
|**filename** | **String** | Original filename, including extension. |  |
|**contentType** | **String** | MIME content type the client will PUT. Must be in the platform-supported list (see GET /v1/doc/accept). The client MUST send the exact same value in the PUT &#x60;Content-Type&#x60; header. |  |
|**lang** | **String** | ISO-639 language code used by the LLM during summarization. Defaults to &#x60;en&#x60;. |  [optional] |
|**provider** | **String** | Free-form label identifying the source of the document. |  [optional] |
|**userId** | **String** | Identifier of the user uploading the document. When the caller&#39;s JWT carries a &#x60;userId&#x60; claim, the value MUST match it — uploads on behalf of a different user are rejected with 403. May be omitted; in that case the JWT&#39;s &#x60;userId&#x60; is used when present. |  [optional] |
|**docCreate** | **OffsetDateTime** | Original creation date of the source document (ISO-8601, UTC). |  [optional] |
|**docUpdate** | **OffsetDateTime** | Original last-modified date of the source document (ISO-8601, UTC). |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | Arbitrary key/value metadata attached to the document. Stored as JSONB. |  [optional] |




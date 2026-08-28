

# Document

A file ingested into a corpus. Holds metadata; the binary content is streamed via the download endpoint.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | Unique identifier of the document (UUIDv4). |  |
|**corpusId** | **UUID** | ID of the corpus this document belongs to. |  |
|**userId** | **String** | Identifier of the user who uploaded the document. May be null when no user identity was provided at upload time. |  [optional] |
|**filename** | **String** | Original filename, as provided at upload time. |  |
|**contentType** | **String** | MIME content type of the file. |  |
|**status** | [**StatusEnum**](#StatusEnum) | Lifecycle status of the document. AWAITING_UPLOAD: created via init, file not yet uploaded. READY: ingestion completed. |  |
|**path** | **String** | Internal storage path of the file. Opaque — use the download endpoint instead. |  [optional] |
|**provider** | **String** | Free-form label identifying the source of the document. |  [optional] |
|**lang** | **String** | ISO-639 language code used during ingestion. |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | Arbitrary JSON metadata attached to the document. Stored as JSONB. |  [optional] |
|**tags** | **List&lt;String&gt;** | Free-form labels used to classify the document. Filter on them with &#x60;GET /v1/doc/?tags&#x3D;…&#x60;. Null when the document carries no tag. |  [optional] |
|**chunk** | **Map&lt;String, Object&gt;** | Chunking configuration used when ingesting this document — an Unstructured chunking option set (&#x60;strategy&#x60;, &#x60;max_characters&#x60;, &#x60;overlap&#x60;, …). Null means the platform default was used (&#x60;by_title&#x60;, &#x60;max_characters: 10000&#x60;, &#x60;combine_text_under_n_chars: 1000&#x60;). See &#x60;DocumentInitRequest.chunk&#x60; for the full key reference. |  [optional] |
|**docCreate** | **OffsetDateTime** | Original creation date of the source document (ISO-8601, UTC). Falls back to upload time when unknown. |  [optional] |
|**docUpdate** | **OffsetDateTime** | Original last-modified date of the source document (ISO-8601, UTC). Falls back to upload time when unknown. |  [optional] |
|**createdAt** | **OffsetDateTime** | Date the document was uploaded to the platform (ISO-8601, UTC). |  |
|**updatedAt** | **OffsetDateTime** | Last update timestamp of the document row (ISO-8601, UTC). |  |
|**size** | **Long** | Size of the source file in bytes. Set after ingestion. |  [optional] |
|**tokens** | **Integer** | Number of LLM tokens consumed to produce the summary. Set after ingestion. |  [optional] |
|**nbWords** | **Integer** | Number of words in the source document. Set after ingestion. |  [optional] |
|**nbPages** | **Integer** | Number of pages of the source document. &#x60;0&#x60; means *not counted yet* — the rendering pipeline reports it during ingestion, so it stays &#x60;0&#x60; until then (and for formats that have no pages). Use it to bound the &#x60;pages&#x60; indices of &#x60;GET /v1/doc/{id}/preview-urls&#x60;, whose valid range is &#x60;0..nbPages-1&#x60;. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| AWAITING_UPLOAD | &quot;AWAITING_UPLOAD&quot; |
| PENDING | &quot;PENDING&quot; |
| PROCESSING | &quot;PROCESSING&quot; |
| READY | &quot;READY&quot; |
| FAILED | &quot;FAILED&quot; |




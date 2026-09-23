

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
|**docCreate** | **OffsetDateTime** | Creation date of the **source** document — the file — as opposed to &#x60;createdAt&#x60;, which is when the platform first saw it (ISO-8601, UTC). Always present: when the upload declared no date, this is the upload instant. |  |
|**docUpdate** | **OffsetDateTime** | Last-modified date of the **source** document (ISO-8601, UTC), on the same terms as &#x60;docCreate&#x60;. Always present, and the one of the two that moves: replacing the content with &#x60;PUT /v1/doc/{id}/init&#x60; re-stamps it with the moment of that call. Correct it with &#x60;PATCH /v1/doc/{id}&#x60; when the new file&#39;s real modification date is known. |  |
|**createdAt** | **OffsetDateTime** | Date the document was uploaded to the platform (ISO-8601, UTC). |  |
|**updatedAt** | **OffsetDateTime** | Last update timestamp of the document row (ISO-8601, UTC). |  |
|**size** | **Long** | Size of the source file in bytes. Set after ingestion. |  [optional] |
|**storage** | **Long** | Bytes this document occupies on the platform — the source file **plus** everything derived from it: rendered page previews, the markdown conversion, the summary and the embedding payloads. Always larger than &#x60;size&#x60; once ingested, often by several times for a document that renders and chunks. This is the figure the storage totals of &#x60;GET /v1/usage/_*&#x60; are built from. &#x60;0&#x60; means *not computed yet* — the processing pipeline reports it during ingestion, so it stays &#x60;0&#x60; until then. |  [optional] |
|**nbChunks** | **Integer** | Number of chunks this document was split into — the passages &#x60;GET /v1/chunk/q?documentId&#x3D;…&#x60; returns for it. &#x60;0&#x60; means *not computed yet* — the processing pipeline reports it during ingestion, so it stays &#x60;0&#x60; until then. |  [optional] |
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




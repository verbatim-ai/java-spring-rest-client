

# Document

A file ingested into a corpus. Holds metadata; the binary content is streamed via the download endpoint.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique identifier of the document (UUIDv4). |  |
|**corpusId** | **String** | ID of the corpus this document belongs to. |  |
|**userId** | **String** | Identifier of the user who uploaded the document. May be null when no user identity was provided at upload time. |  [optional] |
|**filename** | **String** | Original filename, as provided at upload time. |  |
|**contentType** | **String** | MIME content type of the file. |  |
|**status** | [**StatusEnum**](#StatusEnum) | Lifecycle status of the document. AWAITING_UPLOAD: created via init, file not yet uploaded. READY: ingestion completed. |  |
|**path** | **String** | Internal storage path of the file. Opaque — use the download endpoint instead. |  [optional] |
|**provider** | **String** | Free-form label identifying the source of the document. |  [optional] |
|**lang** | **String** | ISO-639 language code used during ingestion. |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | Arbitrary JSON metadata attached to the document. Stored as JSONB. |  [optional] |
|**docCreate** | **OffsetDateTime** | Original creation date of the source document (ISO-8601, UTC). Falls back to upload time when unknown. |  [optional] |
|**docUpdate** | **OffsetDateTime** | Original last-modified date of the source document (ISO-8601, UTC). Falls back to upload time when unknown. |  [optional] |
|**createdAt** | **OffsetDateTime** | Date the document was uploaded to the platform (ISO-8601, UTC). |  |
|**updatedAt** | **OffsetDateTime** | Last update timestamp of the document row (ISO-8601, UTC). |  |
|**size** | **Long** | Size of the source file in bytes. Set after ingestion. |  [optional] |
|**tokens** | **Integer** | Number of LLM tokens consumed to produce the summary. Set after ingestion. |  [optional] |
|**nbWords** | **Integer** | Number of words in the source document. Set after ingestion. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| AWAITING_UPLOAD | &quot;AWAITING_UPLOAD&quot; |
| PENDING | &quot;PENDING&quot; |
| PROCESSING | &quot;PROCESSING&quot; |
| READY | &quot;READY&quot; |
| FAILED | &quot;FAILED&quot; |




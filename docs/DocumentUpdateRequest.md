

# DocumentUpdateRequest

Payload to patch a document. Only the fields you set are updated; omit a field to leave it unchanged.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**filename** | **String** | New filename, including extension. 1–256 characters. Display only — it does not move the stored object nor re-trigger ingestion. Omit to keep the current filename. |  [optional] |
|**docCreate** | **OffsetDateTime** | New creation date of the **source** document (ISO-8601, UTC). Describes the original file, not the platform row — &#x60;createdAt&#x60; is not affected. Omit to keep the current value. |  [optional] |
|**docUpdate** | **OffsetDateTime** | New last-modified date of the **source** document (ISO-8601, UTC). Describes the original file, not the platform row — &#x60;updatedAt&#x60; is not affected. Omit to keep the current value. |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | New JSON metadata. When provided, **replaces** the existing metadata map; omit to keep it unchanged. |  [optional] |




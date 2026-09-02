

# Chunk

One embeddable piece of a document: the text that was vectorised, where it came from, and the metadata the ingestion pipeline attached to it.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | Unique identifier of the chunk (UUIDv4). Same id the &#x60;attachment&#x60; records of a post point at. |  |
|**documentId** | **UUID** | Document the chunk was cut from. |  |
|**corpusId** | **UUID** | Corpus owning the document. Not stored on the chunk — resolved through the document — and reported here because it is half of the storage key of &#x60;body&#x60;. |  |
|**pages** | **List&lt;Integer&gt;** | 1-based page numbers the chunk spans, ascending. A chunk is built from consecutive elements and may cross page boundaries, so this is a span rather than a single page. **Empty** for a chunk that belongs to no page in particular — the document summary is the usual case. |  [optional] |
|**hash** | **String** | MD5 of the chunk body as it was pushed to storage. Equal hashes mean equal text, which is how duplicated content is found across documents. Read-only — it is computed by the ingestion pipeline. |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | Arbitrary JSON metadata attached by the ingestion pipeline. &#x60;kind&#x60; is the key the platform itself sets — &#x60;chunk&#x60; for a piece of the document, &#x60;summary&#x60; for the generated summary. |  [optional] |
|**body** | **String** | The chunk text, read from object storage. Present on &#x60;GET /v1/chunk/{chunkId}&#x60;, and on the listings only when &#x60;body&#x3D;true&#x60; was passed. An empty string means the row exists but its stored body does not — a broken chunk, which is one of the things this API exists to surface. |  [optional] |




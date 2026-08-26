

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
|**tags** | **List&lt;String&gt;** | Free-form labels used to classify the document, so it can later be retrieved with &#x60;GET /v1/doc/?tags&#x3D;…&#x60;. Blanks are dropped and duplicates collapsed; at most 32 tags of 64 characters each. |  [optional] |
|**chunk** | **Map&lt;String, Object&gt;** | Per-document chunking configuration applied during ingestion. Omit it to use the platform default (&#x60;by_title&#x60; with &#x60;max_characters: 10000&#x60; and &#x60;combine_text_under_n_chars: 1000&#x60;).  Keys map **one-to-one onto the Unstructured chunking options** (&lt;https://docs.unstructured.io/open-source/core-functionality/chunking&gt;), so the names and semantics below are theirs, not ours. Everything is optional — send only what you want to change; the ingestion pipeline fills the rest from its defaults.  &#x60;strategy&#x60; — &#x60;by_title&#x60; (default) or &#x60;basic&#x60;. &#x60;by_title&#x60; starts a new chunk at each section heading, keeping a chunk within a single section; &#x60;basic&#x60; ignores structure and fills each chunk to the limit. Use &#x60;by_title&#x60; for structured documents (reports, contracts, manuals) and &#x60;basic&#x60; for flat prose or transcripts.  | Key | Type | Default | Strategy | Meaning | |---|---|---|---|---| | &#x60;strategy&#x60; | string | &#x60;by_title&#x60; | — | &#x60;by_title&#x60; or &#x60;basic&#x60; | | &#x60;max_characters&#x60; | int | &#x60;10000&#x60; | both | Hard cap. No chunk ever exceeds it; an element larger than this is text-split. | | &#x60;new_after_n_chars&#x60; | int | &#x60;max_characters&#x60; | both | Soft cap. A chunk past this size is not extended further, but is not split either. Set it below &#x60;max_characters&#x60; for more even chunks. | | &#x60;overlap&#x60; | int | &#x60;0&#x60; | both | Characters carried over from the end of the previous chunk as a prefix. Applied **only** to chunks produced by text-splitting an oversized element. | | &#x60;overlap_all&#x60; | bool | &#x60;false&#x60; | both | Apply &#x60;overlap&#x60; between all chunks, not just text-split ones. Improves recall across boundaries at the cost of duplicated text in your embeddings. | | &#x60;combine_text_under_n_chars&#x60; | int | &#x60;max_characters&#x60; | &#x60;by_title&#x60; | Combine consecutive small sections until the chunk reaches this size. &#x60;0&#x60; disables combining, so every section becomes its own chunk. | | &#x60;multipage_sections&#x60; | bool | &#x60;true&#x60; | &#x60;by_title&#x60; | Allow a section to span a page break. Set &#x60;false&#x60; to force a new chunk at each page. |  Keys are **not validated** here — the object is stored verbatim and handed to the chunker, so an unknown or malformed key surfaces as a failed ingestion (&#x60;status: FAILED&#x60;) rather than a &#x60;400&#x60; on this call. That is deliberate: it lets new Unstructured options be used the day they ship, with no change to this API.  Sizes are in characters, not tokens. Larger chunks give the LLM more context per citation but retrieve less precisely; &#x60;max_characters&#x60; between 2000 and 10000 is the usual working range.  |  [optional] |




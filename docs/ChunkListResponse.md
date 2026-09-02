

# ChunkListResponse

Paginated list of chunks. Echoes the filters that were actually applied — a filter that was dropped as empty does not appear here.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**corpusId** | **UUID** | Echo of the corpus filter, when one was applied. |  [optional] |
|**documentId** | **UUID** | Echo of the document filter, when one was applied. |  [optional] |
|**hash** | **String** | Echo of the hash filter, when one was applied. |  [optional] |
|**page** | **Integer** | Echo of the page filter, when one was applied. |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | Echo of the metadata fragment used to filter the listing, when applicable. |  [optional] |
|**pageIndex** | **Integer** | Zero-based index of the returned page. |  |
|**pageSize** | **Integer** | Number of items requested per page. |  |
|**total** | **Long** | Total number of chunks matching the filters across every page. |  |
|**items** | [**List&lt;Chunk&gt;**](Chunk.md) | Chunks contained in this page, in reading order: by document, then by the first page each chunk covers, then by id. &#x60;body&#x60; is present only when &#x60;body&#x3D;true&#x60; was passed. |  [optional] |




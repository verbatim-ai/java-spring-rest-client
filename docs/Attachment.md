

# Attachment

Document used as context to produce a system answer.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**postId** | **UUID** | ID of the post (UUIDv4). |  |
|**docId** | **UUID** | ID of the document (UUIDv4). |  |
|**summary** | **String** | Summary of the document (markdown) |  |
|**pages** | **List&lt;Integer&gt;** | Sorted list of page indexes (1-based) retrieved from this document. User endpoint /{id}/preview-urls get secured preview image of the page |  |
|**metadata** | **Map&lt;String, Object&gt;** | Metadata of the source document. |  [optional] |




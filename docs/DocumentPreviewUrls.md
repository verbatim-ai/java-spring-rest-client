

# DocumentPreviewUrls

Presigned URLs for the rendered preview images of a document. Each entry pairs a page index with a rendering size; the client picks the (page, size) it needs.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | ID of the document the previews belong to. |  [optional] |
|**items** | [**List&lt;DocumentPreviewUrl&gt;**](DocumentPreviewUrl.md) | Presigned preview URLs, one per (page, size). May be empty when no preview pages have been generated yet. |  [optional] |




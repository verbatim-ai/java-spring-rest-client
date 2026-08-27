

# DocumentSearchResponse

Page of documents matching a search, with the total number of matches.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**corpusId** | **String** | ID of the searched corpus (UUIDv4). |  |
|**pageIndex** | **Integer** | Zero-based index of the returned page. |  |
|**pageSize** | **Integer** | Number of documents this page can hold — the requested &#x60;pageSize&#x60;. The last page may carry fewer items. |  |
|**total** | **Long** | Total number of documents matching the filters, across every page. Divide by &#x60;pageSize&#x60; to know how many pages to walk. |  |
|**items** | [**List&lt;Document&gt;**](Document.md) | Documents contained in this page, in the requested sort order. |  |




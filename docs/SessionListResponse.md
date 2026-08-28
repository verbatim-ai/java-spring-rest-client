

# SessionListResponse

Paginated list of sessions. Echoes the filter that produced it.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**corpusId** | **UUID** | Echo of the corpus filter, when the listing was filtered by corpus. |  [optional] |
|**userId** | **String** | Echo of the user filter, when the listing was filtered by user. |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | Echo of the metadata fragment used to filter the listing, when applicable. |  [optional] |
|**pageIndex** | **Integer** | Zero-based index of the returned page. |  |
|**pageSize** | **Integer** | Number of items requested per page. |  |
|**total** | **Long** | Total number of sessions matching the filter across every page. |  |
|**items** | [**List&lt;Session&gt;**](Session.md) | Sessions contained in this page, newest first. |  [optional] |




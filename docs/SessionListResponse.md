

# SessionListResponse

Paginated list of sessions. Echoes the filter that produced it.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**corpusId** | **String** | Echo of the corpus filter, when the listing was filtered by corpus. |  |
|**userId** | **String** | Echo of the user filter, when the listing was filtered by user. |  [optional] |
|**orgId** | **String** | Echo of the organization scope (resolved from the caller&#39;s JWT). |  |
|**metadata** | **Map&lt;String, Object&gt;** | Echo of the metadata fragment used to filter the listing, when applicable. |  [optional] |
|**pageIndex** | **Integer** | Zero-based index of the returned page. |  |
|**pageSize** | **Integer** | Number of items requested per page. |  |
|**total** | **Long** | Total number of sessions matching the filter across every page. |  |
|**items** | [**List&lt;Session&gt;**](Session.md) | Sessions contained in this page, newest first. |  [optional] |




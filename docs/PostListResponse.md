

# PostListResponse

Paginated list of posts in a session.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**sessionId** | **UUID** | ID of the session (UUIDv4). |  |
|**pageIndex** | **Integer** | Zero-based index of the returned page. |  |
|**pageSize** | **Integer** | Number of items requested per page. The last page may carry fewer. |  |
|**total** | **Long** | Total number of posts in the session, across every page. Divide by &#x60;pageSize&#x60; to know how many pages to walk. Soft-deleted posts are not counted. |  |
|**order** | [**OrderEnum**](#OrderEnum) | Ordering this page was built under — the &#x60;order&#x60; that was asked for, or &#x60;DESC&#x60; when it was omitted. |  |
|**items** | [**List&lt;Post&gt;**](Post.md) | Posts contained in this page, in the requested order — newest first unless &#x60;order&#x3D;ASC&#x60; was passed. |  [optional] |



## Enum: OrderEnum

| Name | Value |
|---- | -----|
| ASC | &quot;ASC&quot; |
| DESC | &quot;DESC&quot; |




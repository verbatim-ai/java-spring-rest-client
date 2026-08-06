

# PostListResponse

Paginated list of posts in a session.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**sessionId** | **UUID** | ID of the session (UUIDv4). |  |
|**pageIndex** | **Integer** | Zero-based index of the returned page. |  [optional] |
|**items** | [**List&lt;Post&gt;**](Post.md) | Posts contained in this page, newest first. |  [optional] |




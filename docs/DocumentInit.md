

# DocumentInit

Result of initializing a direct-to-storage upload. The client MUST PUT the file content to `uploadUrl` with the matching `Content-Type` header before calling the commit endpoint.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**document** | [**Document**](Document.md) | Created document, in AWAITING_UPLOAD status until commit is called. |  [optional] |
|**uploadUrl** | **String** | Presigned URL to PUT the file content to. Single-use, time-limited. |  [optional] |
|**expiresAt** | **OffsetDateTime** | Wall-clock expiration of &#x60;uploadUrl&#x60; (ISO-8601, UTC). After this, a fresh init is required. |  [optional] |




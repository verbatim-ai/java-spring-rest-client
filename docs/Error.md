

# Error

Standard error payload returned for non-2xx responses.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**timestamp** | **OffsetDateTime** | Server-side timestamp the error was produced (ISO-8601, UTC). |  [optional] |
|**status** | **Integer** | HTTP status code returned to the client. |  [optional] |
|**error** | **String** | HTTP status reason phrase. |  [optional] |
|**message** | **String** | Human-readable error message — safe to surface to API consumers. |  [optional] |
|**path** | **String** | Servlet path of the request that produced the error. |  [optional] |




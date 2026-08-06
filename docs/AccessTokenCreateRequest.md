

# AccessTokenCreateRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**ttl** | **Long** | Token validity in seconds. Defaults to 3600 (1 hour). |  [optional] |
|**issuer** | **String** | Optional label identifying the system that requested the token. |  [optional] |
|**email** | **String** | Optional email of the end-user the token is issued for. |  [optional] |
|**userId** | **String** | Optional user identifier. |  [optional] |
|**scope** | **List&lt;String&gt;** | Optional list of permission scopes to associate with the token. Pattern is DOMAIN:ACTION, where DOMAIN must be one of the values [doc|corpus|session|post|config] and ACTION one of the values [create|read|update|delete] |  [optional] |




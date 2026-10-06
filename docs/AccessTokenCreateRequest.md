

# AccessTokenCreateRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**ttl** | **Long** | Token validity in seconds. Defaults to 3600 (1 hour); at least 10, and at most the platform ceiling (&#x60;app.access-token.max-ttl-seconds&#x60;, 86400 by default). |  [optional] |
|**issuer** | **String** | Optional label identifying the system that requested the token. |  [optional] |
|**email** | **String** | Optional email of the end-user the token is issued for. |  [optional] |
|**userId** | **String** | Optional user identifier. |  [optional] |
|**scope** | **List&lt;String&gt;** | Mandatory, non-empty list of permission scopes the token carries, each &#x60;DOMAIN:ACTION&#x60;. &#x60;GET /v1/auth/access-token/scopes&#x60; lists every valid entry. |  |




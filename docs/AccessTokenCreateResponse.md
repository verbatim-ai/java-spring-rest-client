

# AccessTokenCreateResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**token** | **String** | The opaque access token value. Pass this as the X-Access-Token header on API calls. |  [optional] |
|**createdAt** | **OffsetDateTime** | Creation timestamp (ISO-8601, UTC). |  [optional] |
|**expiresAt** | **OffsetDateTime** | Expiry timestamp (ISO-8601, UTC). Token is invalid after this date. |  [optional] |
|**scope** | **List&lt;String&gt;** | Permission scopes associated with the token, if any. |  [optional] |




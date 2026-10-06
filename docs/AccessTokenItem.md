

# AccessTokenItem

One access token as a listing shows it: every stored attribute, except that the token value is cut down to its first characters. The full value is only ever returned once, by the create call.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | Id of the token. Pass it to &#x60;DELETE /v1/auth/access-token/id/{id}&#x60; to revoke the token. |  [optional] |
|**token** | **String** | First characters of the token value followed by &#x60;...&#x60; — enough to recognise a token, never enough to use it. |  [optional] |
|**orgId** | **UUID** | Organization the token belongs to. |  [optional] |
|**createdAt** | **OffsetDateTime** | Creation timestamp (ISO-8601, UTC). |  [optional] |
|**expiresAt** | **OffsetDateTime** | Expiry timestamp (ISO-8601, UTC). An expired token stays listed until revoked, but no longer authenticates. |  [optional] |
|**issuer** | **String** | Label of the system that requested the token, as given at creation. |  [optional] |
|**email** | **String** | Email of the end-user the token was issued for, as given at creation. |  [optional] |
|**userId** | **String** | User identifier the token was issued for, as given at creation. |  [optional] |
|**scope** | **List&lt;String&gt;** | Permission scopes the token carries. |  [optional] |




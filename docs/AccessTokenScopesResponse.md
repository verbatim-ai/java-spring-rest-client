

# AccessTokenScopesResponse

Every scope an access token can be created with. A scope entry is `DOMAIN:ACTION`; any domain combines with any action.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**domains** | [**List&lt;AccessTokenScopeDomain&gt;**](AccessTokenScopeDomain.md) | Domains a scope entry may name, each with the scopes it makes up. |  [optional] |
|**actions** | [**List&lt;AccessTokenScopeAction&gt;**](AccessTokenScopeAction.md) | Actions a scope entry may ask for, each with the HTTP methods it opens. |  [optional] |
|**scopes** | **List&lt;String&gt;** | Every valid scope entry, as accepted in the &#x60;scope&#x60; of &#x60;POST /v1/auth/access-token/&#x60;. |  [optional] |




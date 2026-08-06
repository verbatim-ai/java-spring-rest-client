

# UsageTokens

Token consumption — lifetime and during the rolling window. Soft-deleted posts and documents are still counted (the tokens were billed at production time).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**total** | **Long** | Lifetime token count, all-time. Includes posts and documents that were since soft-deleted. |  |
|**inPeriod** | **Long** | Tokens produced inside the rolling window — posts (and, at organization-scope, documents) whose &#x60;created_at&#x60; falls in &#x60;[from, to)&#x60;. |  |






# Usage

Aggregated usage metrics over a rolling timeframe. Returned by `GET /v1/usage/all` (organization scope) and `GET /v1/usage/corpus/{corpusId}` (corpus scope).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**timeframe** | [**TimeframeEnum**](#TimeframeEnum) | Rolling window the metrics are aggregated over. |  |
|**from** | **OffsetDateTime** | Inclusive start of the rolling window (ISO-8601, UTC). |  |
|**to** | **OffsetDateTime** | Exclusive end of the rolling window (ISO-8601, UTC). Equal to &#x60;timestamp&#x60;. |  |
|**organizationId** | **String** | ID of the organization the caller belongs to (UUIDv4). |  |
|**corpusId** | **String** | ID of the queried corpus (UUIDv4). &#x60;null&#x60; at organization and user scopes. |  [optional] |
|**userId** | **String** | ID of the queried user, as carried by the JWT or supplied at upload. &#x60;null&#x60; at organization and corpus scopes. |  [optional] |
|**tokens** | [**UsageTokens**](UsageTokens.md) | Token usage. At organization scope, sum of &#x60;post.token&#x60; + &#x60;document.token&#x60;. At corpus scope, sum of &#x60;post.token&#x60; only (vectorization tokens are billed at organization level). |  |
|**corpora** | [**UsageCount**](UsageCount.md) | Corpus counts. Populated at organization scope only; &#x60;null&#x60; at corpus scope. |  |
|**sessions** | [**UsageCount**](UsageCount.md) | Session counts within the scope. |  |
|**posts** | [**UsageCount**](UsageCount.md) | Post counts within the scope. |  |
|**storage** | [**UsageCount**](UsageCount.md) | Storage footprint of documents within the scope. &#x60;total&#x60;/&#x60;created&#x60;/&#x60;removed&#x60; are **bytes**, not item counts. |  |
|**timestamp** | **OffsetDateTime** | Server-side timestamp the metrics were computed at (ISO-8601, UTC). Equal to &#x60;to&#x60;. |  |



## Enum: TimeframeEnum

| Name | Value |
|---- | -----|
| DAY | &quot;Day&quot; |
| WEEK | &quot;Week&quot; |
| MONTH | &quot;Month&quot; |
| YEAR | &quot;Year&quot; |




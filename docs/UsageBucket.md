

# UsageBucket

Metrics for one calendar bucket of the series (UTC). Every bucket is complete; the one currently in progress is not reported.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**from** | **OffsetDateTime** | Inclusive start of the bucket (ISO-8601, UTC). |  |
|**to** | **OffsetDateTime** | Exclusive end of the bucket (ISO-8601, UTC). Equal to the &#x60;from&#x60; of the next bucket. |  |
|**tokens** | **Long** | Tokens produced inside this bucket. At organization and user scope, posts **and** documents; at corpus scope, posts only. |  |
|**corpora** | [**UsageDelta**](UsageDelta.md) | Corpus deltas for this bucket. Populated at organization scope only; &#x60;null&#x60; at corpus and user scopes, as it is at the top level. |  [optional] |
|**sessions** | [**UsageDelta**](UsageDelta.md) | Session deltas for this bucket. |  |
|**posts** | [**UsageDelta**](UsageDelta.md) | Post deltas for this bucket. |  |
|**storage** | [**UsageDelta**](UsageDelta.md) | Storage deltas for this bucket, in **bytes** — not item counts. |  |




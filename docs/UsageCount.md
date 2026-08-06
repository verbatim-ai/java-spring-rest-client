

# UsageCount

Lifetime count and per-window create/remove deltas. For `storage`, the values are bytes rather than item counts.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**total** | **Long** | Lifetime count, all-time. Includes soft-deleted items. |  |
|**created** | **Long** | Items whose &#x60;created_at&#x60; falls inside the rolling window &#x60;[from, to)&#x60;. |  |
|**removed** | **Long** | Items whose &#x60;deleted_at&#x60; falls inside the rolling window &#x60;[from, to)&#x60; (soft-deletes only — a hard delete leaves no trace). |  |




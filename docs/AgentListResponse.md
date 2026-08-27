

# AgentListResponse

Paginated list of the agents an organization can use: its own custom agents plus the platform's core agents, core first.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**pageIndex** | **Integer** | Zero-based index of the returned page. |  [optional] |
|**items** | [**List&lt;Agent&gt;**](Agent.md) | Agents contained in this page. Core agents (&#x60;lock: true&#x60;) sort first, then custom agents by name. |  [optional] |




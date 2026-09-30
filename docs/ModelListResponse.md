

# ModelListResponse

LLM models supported by the platform, everything a client needs to let someone choose one.  Not paginated — the catalog is a handful of entries and `models` always holds all of them, in the order the platform means them to be offered. `total` is their number, so a client can size a picker without walking the list.  `items` is the same list reduced to its identifiers, kept for clients written against the first version of this endpoint. It is deprecated and derived from `models`, so the two can never disagree: read `models[].id` instead. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**total** | **Integer** | Number of models in &#x60;models&#x60;. |  |
|**models** | [**List&lt;Model&gt;**](Model.md) | Supported models, in the order they are meant to be offered. The first is the one to preselect. |  [optional] |
|**items** | **List&lt;String&gt;** | **Deprecated** — identifiers of the supported models, without the display fields. Superseded by &#x60;models[].id&#x60;, which carries the same values in the same order. Still served for existing clients; it will be removed in a future release. |  [optional] |






# CorpusListResponse

Paginated list of corpora belonging to an organization.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**orgId** | **String** | ID of the parent organization (UUIDv4). |  |
|**pageIndex** | **Integer** | Zero-based index of the returned page. |  [optional] |
|**items** | [**List&lt;Corpus&gt;**](Corpus.md) | Corpora contained in this page, newest first. |  [optional] |




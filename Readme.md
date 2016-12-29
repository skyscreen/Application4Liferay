emea-search-portlet : liferay portlet project

1. use service builder(ant service-builder) to generate web service for json formate
2. new trigger for journal_article to save new table for operation record, then output for webservice json format
3. cusotermize role for access the service
4. for servive query, can define customized sql generate bean entitiy customized with new table view for new records 
5. support Collection Entity with manully code and not support table (since v6.2 not support one-to-many relations)
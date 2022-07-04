CREATE TABLE nace_info
(
	order_id INTEGER NOT NULL,
	level_no INTEGER,
	code VARCHAR(255),
	parent VARCHAR(255),
	description VARCHAR(255),
	item_includes CLOB,
	item_also_includes CLOB,
	rulings VARCHAR(255),
	item_excludes CLOB,
	reference_to_isic VARCHAR(255),
	primary key (order_id)
);
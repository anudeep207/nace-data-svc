package co.luxoft.nace.mapper;

import org.springframework.stereotype.Component;

import com.univocity.parsers.common.record.Record;

import co.luxoft.nace.model.NaceData;
import co.luxoft.nace.model.entity.NaceDataInfo;
import co.luxoft.nace.utils.Constant;

@Component
public class NaceDataInfoMapper {
	
	public NaceDataInfo mapFromCsv(final Record record) {
		return NaceDataInfo.builder()
				.order(Integer.parseInt(record.getString(Constant.ORDER)))
				.level(Integer.parseInt(record.getString(Constant.LEVEL)))
				.code(record.getString(Constant.CODE))
				.parent(record.getString(Constant.PARENT))
				.description(record.getString(Constant.DESCRIPTION))
				.itemIncludes(record.getString(Constant.ITEM_INCLUDES))
				.itemAlsoIncludes(record.getString(Constant.ITEM_ALSO_INCLUDES))
				.rulings(record.getString(Constant.RULINGS))
				.itemExcludes(record.getString(Constant.ITEM_EXCLUDES))
				.referenceToISIC(record.getString(Constant.REFERENCE_TO_ISIC))
				.build();	
	}
	
	public NaceData mapFromNaceEntity(final NaceDataInfo entity) {
		return NaceData.builder()
				.order(entity.getOrder())
				.level(entity.getLevel())
				.code(entity.getCode())
				.parent(entity.getParent())
				.description(entity.getDescription())
				.itemIncludes(entity.getItemIncludes())
				.itemAlsoIncludes(entity.getItemAlsoIncludes())
				.rulings(entity.getRulings())
				.itemExcludes(entity.getItemExcludes())
				.referenceToISIC(entity.getReferenceToISIC())
				.build();	
	}
}

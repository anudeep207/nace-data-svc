package co.luxoft.nace.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import co.luxoft.nace.mapper.NaceDataInfoMapper;
import co.luxoft.nace.model.NaceData;
import co.luxoft.nace.model.entity.NaceDataInfo;
import co.luxoft.nace.repository.NaceDetailsRepository;

@RunWith(SpringRunner.class)
public class NaceInfoServiceImplTest {
	
	@InjectMocks
	private NaceInfoServiceImpl naceService;

	@Mock
	private NaceDataInfoMapper mapper;
	
	@Mock
	private NaceDetailsRepository repo;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@DisplayName("Test method to get Order from NAcE dataset")
	void getNaceDetails_getOrder_success() {
		when(repo.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(NaceDataInfo.builder().build()));
		when(mapper.mapFromNaceEntity(Mockito.any(NaceDataInfo.class))).thenReturn(NaceData.builder().build());
		final NaceData naceData = naceService.getNaceDetails(398483);
		assertNotNull("Returned Nace Data not null", naceData);
	}
	
	@Test
	@DisplayName("Test method to check if given order is null")
	void getNaceDetails_getOrder_fail() {
		final NaceData naceData = naceService.getNaceDetails(null);
		assertNull("Returned Nace Data null", naceData);
	}
	
	@Test
	@DisplayName("Test method to check if no order present")
	void getNaceDetails_getOrderNoData_success() {
		when(repo.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(null));
		final NaceData naceData = naceService.getNaceDetails(398483);
		assertNull("Returned Nace Data null", naceData);
	}

}

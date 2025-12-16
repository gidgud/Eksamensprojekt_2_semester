package com.example.eksamensprojekt_2_semester.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.eksamensprojekt_2_semester.model.RentalContract;
import com.example.eksamensprojekt_2_semester.repository.RentalContractRepository;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class) 
public class RentalContractServiceTest {
    
    @Mock
    private RentalContractRepository rentalContractRepository;
    
    @InjectMocks
    private RentalContractService rentalContractService;
    
    private RentalContract testContract;
    
    @BeforeEach 
    public void setUp() {
        testContract = new RentalContract();
        testContract.setId(1);
    }
    
    @Test
    public void testHasRentalContract_True() {
        // Given
        when(rentalContractRepository.getRentalContractById(1)).thenReturn(testContract);
        
        // When
        boolean result = rentalContractService.hasRentalContract(1);
        
        // Then
        assertTrue(result);
        verify(rentalContractRepository, times(1)).getRentalContractById(1);
    }
    
    @Test
    public void testHasRentalContract_False() {
        // Given
        when(rentalContractRepository.getRentalContractById(999)).thenReturn(null);
        
        // When
        boolean result = rentalContractService.hasRentalContract(999);
        
        // Then
        assertFalse(result);
        verify(rentalContractRepository, times(1)).getRentalContractById(999);
    }
    
    @Test
    public void testGetRentalContracts() {
        // Given
        List<RentalContract> contracts = Arrays.asList(testContract);
        when(rentalContractRepository.getRentalContracts()).thenReturn(contracts);
        
        // When
        List<RentalContract> result = rentalContractService.getRentalContracts();
        
        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(rentalContractRepository, times(1)).getRentalContracts();
    }
    
    @Test
    public void testGetAverageRentalPeriod() {
        // Given
        when(rentalContractRepository.getAverageRentalPeriod()).thenReturn(7);
        
        // When
        int result = rentalContractService.getAverageRentalPeriod();
        
        // Then
        assertEquals(7, result);
        verify(rentalContractRepository, times(1)).getAverageRentalPeriod();
    }
    
    @Test
    public void testDeactivateRentalContract() {
        // Given
        doNothing().when(rentalContractRepository).updateRentalContractActive(1, false);
        
        // When
        rentalContractService.deactivateRentalContract(1);
        
        // Then
        verify(rentalContractRepository, times(1)).updateRentalContractActive(1, false);
    }

@Test
public void testGetTotalSum() {
    // Given
    when(rentalContractRepository.getTotalSum()).thenReturn(1500.0);
    
    // When
    double result = rentalContractService.getTotalSum();
    
    // Then
    assertEquals(1500.0, result, 0.01);
    verify(rentalContractRepository, times(1)).getTotalSum();
}

@Test
public void testIsCarActiveByCarId_True() {
    // Given
    when(rentalContractRepository.isCarActiveByCarId(1)).thenReturn(true);
    
    // When
    boolean result = rentalContractService.isCarActiveByCarId(1);
    
    // Then
    assertTrue(result);
    verify(rentalContractRepository, times(1)).isCarActiveByCarId(1);
}
}

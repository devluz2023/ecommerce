package br.com.faluz.shoppingapi.repository;

import shoppingclient.dto.ShopReportDTO;
import br.com.faluz.shoppingapi.model.Shop;

import java.time.LocalDate;
import java.util.List;



public interface ReportRepository  {

    List<Shop> getShopByFilters(LocalDate dataInicio, LocalDate dataFim, Float valorMinimo);

    ShopReportDTO getReportByDate(LocalDate dataInicio, LocalDate dataFim);

}

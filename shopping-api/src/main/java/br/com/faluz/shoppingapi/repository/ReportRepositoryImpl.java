package br.com.faluz.shoppingapi.repository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import shoppingclient.dto.ShopReportDTO;
import br.com.faluz.shoppingapi.model.Shop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public class ReportRepositoryImpl implements ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(LocalDate dataInicio, LocalDate dataFim, Float valorMinimo) {
        StringBuilder sb = new StringBuilder();
        sb.append("select s ");
        sb.append("from shop s ");
        sb.append("where s.date >= :dataInicio ");

        if (dataFim != null) {
            sb.append("and s.date <= :dataFim ");
        }

        if (valorMinimo != null) {
            sb.append("and s.total <= :valorMinimo ");
        }

        Query query = entityManager.createQuery(sb.toString());
        query.setParameter("dataInicio",
                dataInicio.atTime(0, 0));

        if (dataFim != null) {
            query.setParameter("dataFim",
                    dataFim.atTime(23, 59));
        }

        if (valorMinimo != null) {
            query.setParameter("valorMinimo", valorMinimo);
        }
        return query.getResultList();
    }

    @Override
    public ShopReportDTO getReportByDate(LocalDate dataInicio, LocalDate dataFim) {
        StringBuilder sb = new StringBuilder();
        sb.append("select count(sp.id), sum(sp.total), avg(sp.total) ");
        sb.append("from shopping.shop sp ");
        sb.append("where  sp.date >= :dataInicio ");
        sb.append("and sp.date <= :dataFim ");

        Query query = entityManager.createNativeQuery(sb.toString());
        query.setParameter("dataInicio", dataInicio
                .atTime(0, 0));
        query.setParameter("dataFim", dataFim
                .atTime(23, 59));

        Object[] result = (Object[]) query.getSingleResult();
        ShopReportDTO shopReportDTO = new ShopReportDTO();
        shopReportDTO.setCount(((BigInteger) result[0]).intValue());
        shopReportDTO.setTotal((Double) result[1]);
        shopReportDTO.setMean((Double) result[2]);
        return shopReportDTO;
    }

}

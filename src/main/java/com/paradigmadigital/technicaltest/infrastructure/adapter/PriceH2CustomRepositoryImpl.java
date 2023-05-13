package com.paradigmadigital.technicaltest.infrastructure.adapter;

import com.paradigmadigital.technicaltest.infrastructure.entity.PriceH2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Predicate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
class PriceH2CustomRepositoryImpl implements PriceH2CustomRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<PriceH2> findPrices(OffsetDateTime date, Integer productId, Integer brandId) {
    var criteriaBuilder = entityManager.getCriteriaBuilder();
    var query = criteriaBuilder.createQuery(PriceH2.class);
    var priceH2 = query.from(PriceH2.class);
    List<Predicate> predicates = new ArrayList<>();

    if (date != null) {
      predicates.add(criteriaBuilder.and(
          criteriaBuilder.lessThanOrEqualTo(priceH2.get("startDate"), date),
          criteriaBuilder.greaterThanOrEqualTo(priceH2.get("endDate"), date)
      ));
    }
    if (productId != null) {
      predicates.add(criteriaBuilder.equal(priceH2.get("productId"), productId));
    }
    if (brandId != null) {
      predicates.add(criteriaBuilder.equal(priceH2.get("brandId"), brandId));
    }
    query.select(priceH2);
    if (!predicates.isEmpty()) {
      query.where(criteriaBuilder
          .and(predicates.toArray(new Predicate[0])));
    }
    query.orderBy(criteriaBuilder.desc(priceH2.get("priority")));
    return entityManager.createQuery(query)
        .getResultList();
  }
}

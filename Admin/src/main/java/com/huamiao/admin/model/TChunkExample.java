package com.huamiao.admin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TChunkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TChunkExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andChunkNumberIsNull() {
            addCriterion("CHUNK_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andChunkNumberIsNotNull() {
            addCriterion("CHUNK_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andChunkNumberEqualTo(Integer value) {
            addCriterion("CHUNK_NUMBER =", value, "chunkNumber");
            return (Criteria) this;
        }

        public Criteria andChunkNumberNotEqualTo(Integer value) {
            addCriterion("CHUNK_NUMBER <>", value, "chunkNumber");
            return (Criteria) this;
        }

        public Criteria andChunkNumberGreaterThan(Integer value) {
            addCriterion("CHUNK_NUMBER >", value, "chunkNumber");
            return (Criteria) this;
        }

        public Criteria andChunkNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHUNK_NUMBER >=", value, "chunkNumber");
            return (Criteria) this;
        }

        public Criteria andChunkNumberLessThan(Integer value) {
            addCriterion("CHUNK_NUMBER <", value, "chunkNumber");
            return (Criteria) this;
        }

        public Criteria andChunkNumberLessThanOrEqualTo(Integer value) {
            addCriterion("CHUNK_NUMBER <=", value, "chunkNumber");
            return (Criteria) this;
        }

        public Criteria andChunkNumberIn(List<Integer> values) {
            addCriterion("CHUNK_NUMBER in", values, "chunkNumber");
            return (Criteria) this;
        }

        public Criteria andChunkNumberNotIn(List<Integer> values) {
            addCriterion("CHUNK_NUMBER not in", values, "chunkNumber");
            return (Criteria) this;
        }

        public Criteria andChunkNumberBetween(Integer value1, Integer value2) {
            addCriterion("CHUNK_NUMBER between", value1, value2, "chunkNumber");
            return (Criteria) this;
        }

        public Criteria andChunkNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("CHUNK_NUMBER not between", value1, value2, "chunkNumber");
            return (Criteria) this;
        }

        public Criteria andChunkSizeIsNull() {
            addCriterion("CHUNK_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andChunkSizeIsNotNull() {
            addCriterion("CHUNK_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andChunkSizeEqualTo(String value) {
            addCriterion("CHUNK_SIZE =", value, "chunkSize");
            return (Criteria) this;
        }

        public Criteria andChunkSizeNotEqualTo(String value) {
            addCriterion("CHUNK_SIZE <>", value, "chunkSize");
            return (Criteria) this;
        }

        public Criteria andChunkSizeGreaterThan(String value) {
            addCriterion("CHUNK_SIZE >", value, "chunkSize");
            return (Criteria) this;
        }

        public Criteria andChunkSizeGreaterThanOrEqualTo(String value) {
            addCriterion("CHUNK_SIZE >=", value, "chunkSize");
            return (Criteria) this;
        }

        public Criteria andChunkSizeLessThan(String value) {
            addCriterion("CHUNK_SIZE <", value, "chunkSize");
            return (Criteria) this;
        }

        public Criteria andChunkSizeLessThanOrEqualTo(String value) {
            addCriterion("CHUNK_SIZE <=", value, "chunkSize");
            return (Criteria) this;
        }

        public Criteria andChunkSizeLike(String value) {
            addCriterion("CHUNK_SIZE like", value, "chunkSize");
            return (Criteria) this;
        }

        public Criteria andChunkSizeNotLike(String value) {
            addCriterion("CHUNK_SIZE not like", value, "chunkSize");
            return (Criteria) this;
        }

        public Criteria andChunkSizeIn(List<String> values) {
            addCriterion("CHUNK_SIZE in", values, "chunkSize");
            return (Criteria) this;
        }

        public Criteria andChunkSizeNotIn(List<String> values) {
            addCriterion("CHUNK_SIZE not in", values, "chunkSize");
            return (Criteria) this;
        }

        public Criteria andChunkSizeBetween(String value1, String value2) {
            addCriterion("CHUNK_SIZE between", value1, value2, "chunkSize");
            return (Criteria) this;
        }

        public Criteria andChunkSizeNotBetween(String value1, String value2) {
            addCriterion("CHUNK_SIZE not between", value1, value2, "chunkSize");
            return (Criteria) this;
        }

        public Criteria andCurrentChunkSizeIsNull() {
            addCriterion("CURRENT_CHUNK_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andCurrentChunkSizeIsNotNull() {
            addCriterion("CURRENT_CHUNK_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentChunkSizeEqualTo(Double value) {
            addCriterion("CURRENT_CHUNK_SIZE =", value, "currentChunkSize");
            return (Criteria) this;
        }

        public Criteria andCurrentChunkSizeNotEqualTo(Double value) {
            addCriterion("CURRENT_CHUNK_SIZE <>", value, "currentChunkSize");
            return (Criteria) this;
        }

        public Criteria andCurrentChunkSizeGreaterThan(Double value) {
            addCriterion("CURRENT_CHUNK_SIZE >", value, "currentChunkSize");
            return (Criteria) this;
        }

        public Criteria andCurrentChunkSizeGreaterThanOrEqualTo(Double value) {
            addCriterion("CURRENT_CHUNK_SIZE >=", value, "currentChunkSize");
            return (Criteria) this;
        }

        public Criteria andCurrentChunkSizeLessThan(Double value) {
            addCriterion("CURRENT_CHUNK_SIZE <", value, "currentChunkSize");
            return (Criteria) this;
        }

        public Criteria andCurrentChunkSizeLessThanOrEqualTo(Double value) {
            addCriterion("CURRENT_CHUNK_SIZE <=", value, "currentChunkSize");
            return (Criteria) this;
        }

        public Criteria andCurrentChunkSizeIn(List<Double> values) {
            addCriterion("CURRENT_CHUNK_SIZE in", values, "currentChunkSize");
            return (Criteria) this;
        }

        public Criteria andCurrentChunkSizeNotIn(List<Double> values) {
            addCriterion("CURRENT_CHUNK_SIZE not in", values, "currentChunkSize");
            return (Criteria) this;
        }

        public Criteria andCurrentChunkSizeBetween(Double value1, Double value2) {
            addCriterion("CURRENT_CHUNK_SIZE between", value1, value2, "currentChunkSize");
            return (Criteria) this;
        }

        public Criteria andCurrentChunkSizeNotBetween(Double value1, Double value2) {
            addCriterion("CURRENT_CHUNK_SIZE not between", value1, value2, "currentChunkSize");
            return (Criteria) this;
        }

        public Criteria andTotalChunksIsNull() {
            addCriterion("TOTAL_CHUNKS is null");
            return (Criteria) this;
        }

        public Criteria andTotalChunksIsNotNull() {
            addCriterion("TOTAL_CHUNKS is not null");
            return (Criteria) this;
        }

        public Criteria andTotalChunksEqualTo(Integer value) {
            addCriterion("TOTAL_CHUNKS =", value, "totalChunks");
            return (Criteria) this;
        }

        public Criteria andTotalChunksNotEqualTo(Integer value) {
            addCriterion("TOTAL_CHUNKS <>", value, "totalChunks");
            return (Criteria) this;
        }

        public Criteria andTotalChunksGreaterThan(Integer value) {
            addCriterion("TOTAL_CHUNKS >", value, "totalChunks");
            return (Criteria) this;
        }

        public Criteria andTotalChunksGreaterThanOrEqualTo(Integer value) {
            addCriterion("TOTAL_CHUNKS >=", value, "totalChunks");
            return (Criteria) this;
        }

        public Criteria andTotalChunksLessThan(Integer value) {
            addCriterion("TOTAL_CHUNKS <", value, "totalChunks");
            return (Criteria) this;
        }

        public Criteria andTotalChunksLessThanOrEqualTo(Integer value) {
            addCriterion("TOTAL_CHUNKS <=", value, "totalChunks");
            return (Criteria) this;
        }

        public Criteria andTotalChunksIn(List<Integer> values) {
            addCriterion("TOTAL_CHUNKS in", values, "totalChunks");
            return (Criteria) this;
        }

        public Criteria andTotalChunksNotIn(List<Integer> values) {
            addCriterion("TOTAL_CHUNKS not in", values, "totalChunks");
            return (Criteria) this;
        }

        public Criteria andTotalChunksBetween(Integer value1, Integer value2) {
            addCriterion("TOTAL_CHUNKS between", value1, value2, "totalChunks");
            return (Criteria) this;
        }

        public Criteria andTotalChunksNotBetween(Integer value1, Integer value2) {
            addCriterion("TOTAL_CHUNKS not between", value1, value2, "totalChunks");
            return (Criteria) this;
        }

        public Criteria andTotalSizeIsNull() {
            addCriterion("TOTAL_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andTotalSizeIsNotNull() {
            addCriterion("TOTAL_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSizeEqualTo(Long value) {
            addCriterion("TOTAL_SIZE =", value, "totalSize");
            return (Criteria) this;
        }

        public Criteria andTotalSizeNotEqualTo(Long value) {
            addCriterion("TOTAL_SIZE <>", value, "totalSize");
            return (Criteria) this;
        }

        public Criteria andTotalSizeGreaterThan(Long value) {
            addCriterion("TOTAL_SIZE >", value, "totalSize");
            return (Criteria) this;
        }

        public Criteria andTotalSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTAL_SIZE >=", value, "totalSize");
            return (Criteria) this;
        }

        public Criteria andTotalSizeLessThan(Long value) {
            addCriterion("TOTAL_SIZE <", value, "totalSize");
            return (Criteria) this;
        }

        public Criteria andTotalSizeLessThanOrEqualTo(Long value) {
            addCriterion("TOTAL_SIZE <=", value, "totalSize");
            return (Criteria) this;
        }

        public Criteria andTotalSizeIn(List<Long> values) {
            addCriterion("TOTAL_SIZE in", values, "totalSize");
            return (Criteria) this;
        }

        public Criteria andTotalSizeNotIn(List<Long> values) {
            addCriterion("TOTAL_SIZE not in", values, "totalSize");
            return (Criteria) this;
        }

        public Criteria andTotalSizeBetween(Long value1, Long value2) {
            addCriterion("TOTAL_SIZE between", value1, value2, "totalSize");
            return (Criteria) this;
        }

        public Criteria andTotalSizeNotBetween(Long value1, Long value2) {
            addCriterion("TOTAL_SIZE not between", value1, value2, "totalSize");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("LOCATION =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("LOCATION <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("LOCATION >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("LOCATION <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("LOCATION <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("LOCATION like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("LOCATION not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("LOCATION in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("LOCATION not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("LOCATION between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("LOCATION not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andCreIdIsNull() {
            addCriterion("CRE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreIdIsNotNull() {
            addCriterion("CRE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreIdEqualTo(Long value) {
            addCriterion("CRE_ID =", value, "creId");
            return (Criteria) this;
        }

        public Criteria andCreIdNotEqualTo(Long value) {
            addCriterion("CRE_ID <>", value, "creId");
            return (Criteria) this;
        }

        public Criteria andCreIdGreaterThan(Long value) {
            addCriterion("CRE_ID >", value, "creId");
            return (Criteria) this;
        }

        public Criteria andCreIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CRE_ID >=", value, "creId");
            return (Criteria) this;
        }

        public Criteria andCreIdLessThan(Long value) {
            addCriterion("CRE_ID <", value, "creId");
            return (Criteria) this;
        }

        public Criteria andCreIdLessThanOrEqualTo(Long value) {
            addCriterion("CRE_ID <=", value, "creId");
            return (Criteria) this;
        }

        public Criteria andCreIdIn(List<Long> values) {
            addCriterion("CRE_ID in", values, "creId");
            return (Criteria) this;
        }

        public Criteria andCreIdNotIn(List<Long> values) {
            addCriterion("CRE_ID not in", values, "creId");
            return (Criteria) this;
        }

        public Criteria andCreIdBetween(Long value1, Long value2) {
            addCriterion("CRE_ID between", value1, value2, "creId");
            return (Criteria) this;
        }

        public Criteria andCreIdNotBetween(Long value1, Long value2) {
            addCriterion("CRE_ID not between", value1, value2, "creId");
            return (Criteria) this;
        }

        public Criteria andCreTimeIsNull() {
            addCriterion("CRE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreTimeIsNotNull() {
            addCriterion("CRE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreTimeEqualTo(Date value) {
            addCriterion("CRE_TIME =", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeNotEqualTo(Date value) {
            addCriterion("CRE_TIME <>", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeGreaterThan(Date value) {
            addCriterion("CRE_TIME >", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CRE_TIME >=", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeLessThan(Date value) {
            addCriterion("CRE_TIME <", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeLessThanOrEqualTo(Date value) {
            addCriterion("CRE_TIME <=", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeIn(List<Date> values) {
            addCriterion("CRE_TIME in", values, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeNotIn(List<Date> values) {
            addCriterion("CRE_TIME not in", values, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeBetween(Date value1, Date value2) {
            addCriterion("CRE_TIME between", value1, value2, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeNotBetween(Date value1, Date value2) {
            addCriterion("CRE_TIME not between", value1, value2, "creTime");
            return (Criteria) this;
        }

        public Criteria andUpdIdIsNull() {
            addCriterion("UPD_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdIdIsNotNull() {
            addCriterion("UPD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdIdEqualTo(Long value) {
            addCriterion("UPD_ID =", value, "updId");
            return (Criteria) this;
        }

        public Criteria andUpdIdNotEqualTo(Long value) {
            addCriterion("UPD_ID <>", value, "updId");
            return (Criteria) this;
        }

        public Criteria andUpdIdGreaterThan(Long value) {
            addCriterion("UPD_ID >", value, "updId");
            return (Criteria) this;
        }

        public Criteria andUpdIdGreaterThanOrEqualTo(Long value) {
            addCriterion("UPD_ID >=", value, "updId");
            return (Criteria) this;
        }

        public Criteria andUpdIdLessThan(Long value) {
            addCriterion("UPD_ID <", value, "updId");
            return (Criteria) this;
        }

        public Criteria andUpdIdLessThanOrEqualTo(Long value) {
            addCriterion("UPD_ID <=", value, "updId");
            return (Criteria) this;
        }

        public Criteria andUpdIdIn(List<Long> values) {
            addCriterion("UPD_ID in", values, "updId");
            return (Criteria) this;
        }

        public Criteria andUpdIdNotIn(List<Long> values) {
            addCriterion("UPD_ID not in", values, "updId");
            return (Criteria) this;
        }

        public Criteria andUpdIdBetween(Long value1, Long value2) {
            addCriterion("UPD_ID between", value1, value2, "updId");
            return (Criteria) this;
        }

        public Criteria andUpdIdNotBetween(Long value1, Long value2) {
            addCriterion("UPD_ID not between", value1, value2, "updId");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNull() {
            addCriterion("UPD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNotNull() {
            addCriterion("UPD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeEqualTo(Date value) {
            addCriterion("UPD_TIME =", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotEqualTo(Date value) {
            addCriterion("UPD_TIME <>", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThan(Date value) {
            addCriterion("UPD_TIME >", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPD_TIME >=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThan(Date value) {
            addCriterion("UPD_TIME <", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPD_TIME <=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIn(List<Date> values) {
            addCriterion("UPD_TIME in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotIn(List<Date> values) {
            addCriterion("UPD_TIME not in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeBetween(Date value1, Date value2) {
            addCriterion("UPD_TIME between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPD_TIME not between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("FILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("FILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("FILE_NAME =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("FILE_NAME <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("FILE_NAME >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_NAME >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("FILE_NAME <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("FILE_NAME <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("FILE_NAME like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("FILE_NAME not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("FILE_NAME in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("FILE_NAME not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("FILE_NAME between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("FILE_NAME not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andIdentifierIsNull() {
            addCriterion("IDENTIFIER is null");
            return (Criteria) this;
        }

        public Criteria andIdentifierIsNotNull() {
            addCriterion("IDENTIFIER is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifierEqualTo(String value) {
            addCriterion("IDENTIFIER =", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotEqualTo(String value) {
            addCriterion("IDENTIFIER <>", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierGreaterThan(String value) {
            addCriterion("IDENTIFIER >", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierGreaterThanOrEqualTo(String value) {
            addCriterion("IDENTIFIER >=", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierLessThan(String value) {
            addCriterion("IDENTIFIER <", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierLessThanOrEqualTo(String value) {
            addCriterion("IDENTIFIER <=", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierLike(String value) {
            addCriterion("IDENTIFIER like", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotLike(String value) {
            addCriterion("IDENTIFIER not like", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierIn(List<String> values) {
            addCriterion("IDENTIFIER in", values, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotIn(List<String> values) {
            addCriterion("IDENTIFIER not in", values, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierBetween(String value1, String value2) {
            addCriterion("IDENTIFIER between", value1, value2, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotBetween(String value1, String value2) {
            addCriterion("IDENTIFIER not between", value1, value2, "identifier");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
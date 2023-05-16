package com.huamiao.blog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMessageExample() {
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

        public Criteria andSourceIdIsNull() {
            addCriterion("SOURCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("SOURCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(Long value) {
            addCriterion("SOURCE_ID =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(Long value) {
            addCriterion("SOURCE_ID <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(Long value) {
            addCriterion("SOURCE_ID >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SOURCE_ID >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(Long value) {
            addCriterion("SOURCE_ID <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(Long value) {
            addCriterion("SOURCE_ID <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<Long> values) {
            addCriterion("SOURCE_ID in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<Long> values) {
            addCriterion("SOURCE_ID not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(Long value1, Long value2) {
            addCriterion("SOURCE_ID between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(Long value1, Long value2) {
            addCriterion("SOURCE_ID not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNull() {
            addCriterion("TARGET_ID is null");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNotNull() {
            addCriterion("TARGET_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTargetIdEqualTo(Long value) {
            addCriterion("TARGET_ID =", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotEqualTo(Long value) {
            addCriterion("TARGET_ID <>", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThan(Long value) {
            addCriterion("TARGET_ID >", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThanOrEqualTo(Long value) {
            addCriterion("TARGET_ID >=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThan(Long value) {
            addCriterion("TARGET_ID <", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThanOrEqualTo(Long value) {
            addCriterion("TARGET_ID <=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdIn(List<Long> values) {
            addCriterion("TARGET_ID in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotIn(List<Long> values) {
            addCriterion("TARGET_ID not in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdBetween(Long value1, Long value2) {
            addCriterion("TARGET_ID between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotBetween(Long value1, Long value2) {
            addCriterion("TARGET_ID not between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andIfReadIsNull() {
            addCriterion("IF_READ is null");
            return (Criteria) this;
        }

        public Criteria andIfReadIsNotNull() {
            addCriterion("IF_READ is not null");
            return (Criteria) this;
        }

        public Criteria andIfReadEqualTo(Byte value) {
            addCriterion("IF_READ =", value, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadNotEqualTo(Byte value) {
            addCriterion("IF_READ <>", value, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadGreaterThan(Byte value) {
            addCriterion("IF_READ >", value, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadGreaterThanOrEqualTo(Byte value) {
            addCriterion("IF_READ >=", value, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadLessThan(Byte value) {
            addCriterion("IF_READ <", value, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadLessThanOrEqualTo(Byte value) {
            addCriterion("IF_READ <=", value, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadIn(List<Byte> values) {
            addCriterion("IF_READ in", values, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadNotIn(List<Byte> values) {
            addCriterion("IF_READ not in", values, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadBetween(Byte value1, Byte value2) {
            addCriterion("IF_READ between", value1, value2, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadNotBetween(Byte value1, Byte value2) {
            addCriterion("IF_READ not between", value1, value2, "ifRead");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
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

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("TYPE not between", value1, value2, "type");
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
package com.huamiao.admin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDictExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDictExample() {
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

        public Criteria andDictCodeIsNull() {
            addCriterion("DICT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDictCodeIsNotNull() {
            addCriterion("DICT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDictCodeEqualTo(String value) {
            addCriterion("DICT_CODE =", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotEqualTo(String value) {
            addCriterion("DICT_CODE <>", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeGreaterThan(String value) {
            addCriterion("DICT_CODE >", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_CODE >=", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLessThan(String value) {
            addCriterion("DICT_CODE <", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLessThanOrEqualTo(String value) {
            addCriterion("DICT_CODE <=", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLike(String value) {
            addCriterion("DICT_CODE like", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotLike(String value) {
            addCriterion("DICT_CODE not like", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeIn(List<String> values) {
            addCriterion("DICT_CODE in", values, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotIn(List<String> values) {
            addCriterion("DICT_CODE not in", values, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeBetween(String value1, String value2) {
            addCriterion("DICT_CODE between", value1, value2, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotBetween(String value1, String value2) {
            addCriterion("DICT_CODE not between", value1, value2, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictLabelIsNull() {
            addCriterion("DICT_LABEL is null");
            return (Criteria) this;
        }

        public Criteria andDictLabelIsNotNull() {
            addCriterion("DICT_LABEL is not null");
            return (Criteria) this;
        }

        public Criteria andDictLabelEqualTo(String value) {
            addCriterion("DICT_LABEL =", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelNotEqualTo(String value) {
            addCriterion("DICT_LABEL <>", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelGreaterThan(String value) {
            addCriterion("DICT_LABEL >", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_LABEL >=", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelLessThan(String value) {
            addCriterion("DICT_LABEL <", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelLessThanOrEqualTo(String value) {
            addCriterion("DICT_LABEL <=", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelLike(String value) {
            addCriterion("DICT_LABEL like", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelNotLike(String value) {
            addCriterion("DICT_LABEL not like", value, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelIn(List<String> values) {
            addCriterion("DICT_LABEL in", values, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelNotIn(List<String> values) {
            addCriterion("DICT_LABEL not in", values, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelBetween(String value1, String value2) {
            addCriterion("DICT_LABEL between", value1, value2, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andDictLabelNotBetween(String value1, String value2) {
            addCriterion("DICT_LABEL not between", value1, value2, "dictLabel");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIsNull() {
            addCriterion("CATEGORY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIsNotNull() {
            addCriterion("CATEGORY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeEqualTo(String value) {
            addCriterion("CATEGORY_CODE =", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotEqualTo(String value) {
            addCriterion("CATEGORY_CODE <>", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeGreaterThan(String value) {
            addCriterion("CATEGORY_CODE >", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CATEGORY_CODE >=", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLessThan(String value) {
            addCriterion("CATEGORY_CODE <", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLessThanOrEqualTo(String value) {
            addCriterion("CATEGORY_CODE <=", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLike(String value) {
            addCriterion("CATEGORY_CODE like", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotLike(String value) {
            addCriterion("CATEGORY_CODE not like", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIn(List<String> values) {
            addCriterion("CATEGORY_CODE in", values, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotIn(List<String> values) {
            addCriterion("CATEGORY_CODE not in", values, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeBetween(String value1, String value2) {
            addCriterion("CATEGORY_CODE between", value1, value2, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotBetween(String value1, String value2) {
            addCriterion("CATEGORY_CODE not between", value1, value2, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryLabelIsNull() {
            addCriterion("CATEGORY_LABEL is null");
            return (Criteria) this;
        }

        public Criteria andCategoryLabelIsNotNull() {
            addCriterion("CATEGORY_LABEL is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryLabelEqualTo(String value) {
            addCriterion("CATEGORY_LABEL =", value, "categoryLabel");
            return (Criteria) this;
        }

        public Criteria andCategoryLabelNotEqualTo(String value) {
            addCriterion("CATEGORY_LABEL <>", value, "categoryLabel");
            return (Criteria) this;
        }

        public Criteria andCategoryLabelGreaterThan(String value) {
            addCriterion("CATEGORY_LABEL >", value, "categoryLabel");
            return (Criteria) this;
        }

        public Criteria andCategoryLabelGreaterThanOrEqualTo(String value) {
            addCriterion("CATEGORY_LABEL >=", value, "categoryLabel");
            return (Criteria) this;
        }

        public Criteria andCategoryLabelLessThan(String value) {
            addCriterion("CATEGORY_LABEL <", value, "categoryLabel");
            return (Criteria) this;
        }

        public Criteria andCategoryLabelLessThanOrEqualTo(String value) {
            addCriterion("CATEGORY_LABEL <=", value, "categoryLabel");
            return (Criteria) this;
        }

        public Criteria andCategoryLabelLike(String value) {
            addCriterion("CATEGORY_LABEL like", value, "categoryLabel");
            return (Criteria) this;
        }

        public Criteria andCategoryLabelNotLike(String value) {
            addCriterion("CATEGORY_LABEL not like", value, "categoryLabel");
            return (Criteria) this;
        }

        public Criteria andCategoryLabelIn(List<String> values) {
            addCriterion("CATEGORY_LABEL in", values, "categoryLabel");
            return (Criteria) this;
        }

        public Criteria andCategoryLabelNotIn(List<String> values) {
            addCriterion("CATEGORY_LABEL not in", values, "categoryLabel");
            return (Criteria) this;
        }

        public Criteria andCategoryLabelBetween(String value1, String value2) {
            addCriterion("CATEGORY_LABEL between", value1, value2, "categoryLabel");
            return (Criteria) this;
        }

        public Criteria andCategoryLabelNotBetween(String value1, String value2) {
            addCriterion("CATEGORY_LABEL not between", value1, value2, "categoryLabel");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNull() {
            addCriterion("SEQUENCE is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNotNull() {
            addCriterion("SEQUENCE is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceEqualTo(Integer value) {
            addCriterion("SEQUENCE =", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotEqualTo(Integer value) {
            addCriterion("SEQUENCE <>", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThan(Integer value) {
            addCriterion("SEQUENCE >", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEQUENCE >=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThan(Integer value) {
            addCriterion("SEQUENCE <", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("SEQUENCE <=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceIn(List<Integer> values) {
            addCriterion("SEQUENCE in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotIn(List<Integer> values) {
            addCriterion("SEQUENCE not in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceBetween(Integer value1, Integer value2) {
            addCriterion("SEQUENCE between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("SEQUENCE not between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andDateTypeIsNull() {
            addCriterion("DATE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDateTypeIsNotNull() {
            addCriterion("DATE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDateTypeEqualTo(String value) {
            addCriterion("DATE_TYPE =", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeNotEqualTo(String value) {
            addCriterion("DATE_TYPE <>", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeGreaterThan(String value) {
            addCriterion("DATE_TYPE >", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DATE_TYPE >=", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeLessThan(String value) {
            addCriterion("DATE_TYPE <", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeLessThanOrEqualTo(String value) {
            addCriterion("DATE_TYPE <=", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeLike(String value) {
            addCriterion("DATE_TYPE like", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeNotLike(String value) {
            addCriterion("DATE_TYPE not like", value, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeIn(List<String> values) {
            addCriterion("DATE_TYPE in", values, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeNotIn(List<String> values) {
            addCriterion("DATE_TYPE not in", values, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeBetween(String value1, String value2) {
            addCriterion("DATE_TYPE between", value1, value2, "dateType");
            return (Criteria) this;
        }

        public Criteria andDateTypeNotBetween(String value1, String value2) {
            addCriterion("DATE_TYPE not between", value1, value2, "dateType");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("CREATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("CREATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(Long value) {
            addCriterion("CREATE_ID =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(Long value) {
            addCriterion("CREATE_ID <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(Long value) {
            addCriterion("CREATE_ID >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CREATE_ID >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(Long value) {
            addCriterion("CREATE_ID <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(Long value) {
            addCriterion("CREATE_ID <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<Long> values) {
            addCriterion("CREATE_ID in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<Long> values) {
            addCriterion("CREATE_ID not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(Long value1, Long value2) {
            addCriterion("CREATE_ID between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(Long value1, Long value2) {
            addCriterion("CREATE_ID not between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNull() {
            addCriterion("UPDATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNotNull() {
            addCriterion("UPDATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdEqualTo(Long value) {
            addCriterion("UPDATE_ID =", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotEqualTo(Long value) {
            addCriterion("UPDATE_ID <>", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThan(Long value) {
            addCriterion("UPDATE_ID >", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("UPDATE_ID >=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThan(Long value) {
            addCriterion("UPDATE_ID <", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThanOrEqualTo(Long value) {
            addCriterion("UPDATE_ID <=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIn(List<Long> values) {
            addCriterion("UPDATE_ID in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotIn(List<Long> values) {
            addCriterion("UPDATE_ID not in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdBetween(Long value1, Long value2) {
            addCriterion("UPDATE_ID between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotBetween(Long value1, Long value2) {
            addCriterion("UPDATE_ID not between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("VERSION not between", value1, value2, "version");
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
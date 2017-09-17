package com.nekostoryweb.dao.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReserveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReserveExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andReserveTimeIsNull() {
            addCriterion("reserve_time is null");
            return (Criteria) this;
        }

        public Criteria andReserveTimeIsNotNull() {
            addCriterion("reserve_time is not null");
            return (Criteria) this;
        }

        public Criteria andReserveTimeEqualTo(Date value) {
            addCriterion("reserve_time =", value, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeNotEqualTo(Date value) {
            addCriterion("reserve_time <>", value, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeGreaterThan(Date value) {
            addCriterion("reserve_time >", value, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reserve_time >=", value, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeLessThan(Date value) {
            addCriterion("reserve_time <", value, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeLessThanOrEqualTo(Date value) {
            addCriterion("reserve_time <=", value, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeIn(List<Date> values) {
            addCriterion("reserve_time in", values, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeNotIn(List<Date> values) {
            addCriterion("reserve_time not in", values, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeBetween(Date value1, Date value2) {
            addCriterion("reserve_time between", value1, value2, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeNotBetween(Date value1, Date value2) {
            addCriterion("reserve_time not between", value1, value2, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveIpIsNull() {
            addCriterion("reserve_ip is null");
            return (Criteria) this;
        }

        public Criteria andReserveIpIsNotNull() {
            addCriterion("reserve_ip is not null");
            return (Criteria) this;
        }

        public Criteria andReserveIpEqualTo(String value) {
            addCriterion("reserve_ip =", value, "reserveIp");
            return (Criteria) this;
        }

        public Criteria andReserveIpNotEqualTo(String value) {
            addCriterion("reserve_ip <>", value, "reserveIp");
            return (Criteria) this;
        }

        public Criteria andReserveIpGreaterThan(String value) {
            addCriterion("reserve_ip >", value, "reserveIp");
            return (Criteria) this;
        }

        public Criteria andReserveIpGreaterThanOrEqualTo(String value) {
            addCriterion("reserve_ip >=", value, "reserveIp");
            return (Criteria) this;
        }

        public Criteria andReserveIpLessThan(String value) {
            addCriterion("reserve_ip <", value, "reserveIp");
            return (Criteria) this;
        }

        public Criteria andReserveIpLessThanOrEqualTo(String value) {
            addCriterion("reserve_ip <=", value, "reserveIp");
            return (Criteria) this;
        }

        public Criteria andReserveIpLike(String value) {
            addCriterion("reserve_ip like", value, "reserveIp");
            return (Criteria) this;
        }

        public Criteria andReserveIpNotLike(String value) {
            addCriterion("reserve_ip not like", value, "reserveIp");
            return (Criteria) this;
        }

        public Criteria andReserveIpIn(List<String> values) {
            addCriterion("reserve_ip in", values, "reserveIp");
            return (Criteria) this;
        }

        public Criteria andReserveIpNotIn(List<String> values) {
            addCriterion("reserve_ip not in", values, "reserveIp");
            return (Criteria) this;
        }

        public Criteria andReserveIpBetween(String value1, String value2) {
            addCriterion("reserve_ip between", value1, value2, "reserveIp");
            return (Criteria) this;
        }

        public Criteria andReserveIpNotBetween(String value1, String value2) {
            addCriterion("reserve_ip not between", value1, value2, "reserveIp");
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
package com.keyone.pojo;

import java.util.ArrayList;
import java.util.List;

public class CellrecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CellrecordExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andToidIsNull() {
            addCriterion("Toid is null");
            return (Criteria) this;
        }

        public Criteria andToidIsNotNull() {
            addCriterion("Toid is not null");
            return (Criteria) this;
        }

        public Criteria andToidEqualTo(String value) {
            addCriterion("Toid =", value, "toid");
            return (Criteria) this;
        }

        public Criteria andToidNotEqualTo(String value) {
            addCriterion("Toid <>", value, "toid");
            return (Criteria) this;
        }

        public Criteria andToidGreaterThan(String value) {
            addCriterion("Toid >", value, "toid");
            return (Criteria) this;
        }

        public Criteria andToidGreaterThanOrEqualTo(String value) {
            addCriterion("Toid >=", value, "toid");
            return (Criteria) this;
        }

        public Criteria andToidLessThan(String value) {
            addCriterion("Toid <", value, "toid");
            return (Criteria) this;
        }

        public Criteria andToidLessThanOrEqualTo(String value) {
            addCriterion("Toid <=", value, "toid");
            return (Criteria) this;
        }

        public Criteria andToidLike(String value) {
            addCriterion("Toid like", value, "toid");
            return (Criteria) this;
        }

        public Criteria andToidNotLike(String value) {
            addCriterion("Toid not like", value, "toid");
            return (Criteria) this;
        }

        public Criteria andToidIn(List<String> values) {
            addCriterion("Toid in", values, "toid");
            return (Criteria) this;
        }

        public Criteria andToidNotIn(List<String> values) {
            addCriterion("Toid not in", values, "toid");
            return (Criteria) this;
        }

        public Criteria andToidBetween(String value1, String value2) {
            addCriterion("Toid between", value1, value2, "toid");
            return (Criteria) this;
        }

        public Criteria andToidNotBetween(String value1, String value2) {
            addCriterion("Toid not between", value1, value2, "toid");
            return (Criteria) this;
        }

        public Criteria andCellnumIsNull() {
            addCriterion("Cellnum is null");
            return (Criteria) this;
        }

        public Criteria andCellnumIsNotNull() {
            addCriterion("Cellnum is not null");
            return (Criteria) this;
        }

        public Criteria andCellnumEqualTo(Long value) {
            addCriterion("Cellnum =", value, "cellnum");
            return (Criteria) this;
        }

        public Criteria andCellnumNotEqualTo(Long value) {
            addCriterion("Cellnum <>", value, "cellnum");
            return (Criteria) this;
        }

        public Criteria andCellnumGreaterThan(Long value) {
            addCriterion("Cellnum >", value, "cellnum");
            return (Criteria) this;
        }

        public Criteria andCellnumGreaterThanOrEqualTo(Long value) {
            addCriterion("Cellnum >=", value, "cellnum");
            return (Criteria) this;
        }

        public Criteria andCellnumLessThan(Long value) {
            addCriterion("Cellnum <", value, "cellnum");
            return (Criteria) this;
        }

        public Criteria andCellnumLessThanOrEqualTo(Long value) {
            addCriterion("Cellnum <=", value, "cellnum");
            return (Criteria) this;
        }

        public Criteria andCellnumIn(List<Long> values) {
            addCriterion("Cellnum in", values, "cellnum");
            return (Criteria) this;
        }

        public Criteria andCellnumNotIn(List<Long> values) {
            addCriterion("Cellnum not in", values, "cellnum");
            return (Criteria) this;
        }

        public Criteria andCellnumBetween(Long value1, Long value2) {
            addCriterion("Cellnum between", value1, value2, "cellnum");
            return (Criteria) this;
        }

        public Criteria andCellnumNotBetween(Long value1, Long value2) {
            addCriterion("Cellnum not between", value1, value2, "cellnum");
            return (Criteria) this;
        }

        public Criteria andCellstatusIsNull() {
            addCriterion("Cellstatus is null");
            return (Criteria) this;
        }

        public Criteria andCellstatusIsNotNull() {
            addCriterion("Cellstatus is not null");
            return (Criteria) this;
        }

        public Criteria andCellstatusEqualTo(String value) {
            addCriterion("Cellstatus =", value, "cellstatus");
            return (Criteria) this;
        }

        public Criteria andCellstatusNotEqualTo(String value) {
            addCriterion("Cellstatus <>", value, "cellstatus");
            return (Criteria) this;
        }

        public Criteria andCellstatusGreaterThan(String value) {
            addCriterion("Cellstatus >", value, "cellstatus");
            return (Criteria) this;
        }

        public Criteria andCellstatusGreaterThanOrEqualTo(String value) {
            addCriterion("Cellstatus >=", value, "cellstatus");
            return (Criteria) this;
        }

        public Criteria andCellstatusLessThan(String value) {
            addCriterion("Cellstatus <", value, "cellstatus");
            return (Criteria) this;
        }

        public Criteria andCellstatusLessThanOrEqualTo(String value) {
            addCriterion("Cellstatus <=", value, "cellstatus");
            return (Criteria) this;
        }

        public Criteria andCellstatusLike(String value) {
            addCriterion("Cellstatus like", value, "cellstatus");
            return (Criteria) this;
        }

        public Criteria andCellstatusNotLike(String value) {
            addCriterion("Cellstatus not like", value, "cellstatus");
            return (Criteria) this;
        }

        public Criteria andCellstatusIn(List<String> values) {
            addCriterion("Cellstatus in", values, "cellstatus");
            return (Criteria) this;
        }

        public Criteria andCellstatusNotIn(List<String> values) {
            addCriterion("Cellstatus not in", values, "cellstatus");
            return (Criteria) this;
        }

        public Criteria andCellstatusBetween(String value1, String value2) {
            addCriterion("Cellstatus between", value1, value2, "cellstatus");
            return (Criteria) this;
        }

        public Criteria andCellstatusNotBetween(String value1, String value2) {
            addCriterion("Cellstatus not between", value1, value2, "cellstatus");
            return (Criteria) this;
        }

        public Criteria andOsresultIsNull() {
            addCriterion("Osresult is null");
            return (Criteria) this;
        }

        public Criteria andOsresultIsNotNull() {
            addCriterion("Osresult is not null");
            return (Criteria) this;
        }

        public Criteria andOsresultEqualTo(String value) {
            addCriterion("Osresult =", value, "osresult");
            return (Criteria) this;
        }

        public Criteria andOsresultNotEqualTo(String value) {
            addCriterion("Osresult <>", value, "osresult");
            return (Criteria) this;
        }

        public Criteria andOsresultGreaterThan(String value) {
            addCriterion("Osresult >", value, "osresult");
            return (Criteria) this;
        }

        public Criteria andOsresultGreaterThanOrEqualTo(String value) {
            addCriterion("Osresult >=", value, "osresult");
            return (Criteria) this;
        }

        public Criteria andOsresultLessThan(String value) {
            addCriterion("Osresult <", value, "osresult");
            return (Criteria) this;
        }

        public Criteria andOsresultLessThanOrEqualTo(String value) {
            addCriterion("Osresult <=", value, "osresult");
            return (Criteria) this;
        }

        public Criteria andOsresultLike(String value) {
            addCriterion("Osresult like", value, "osresult");
            return (Criteria) this;
        }

        public Criteria andOsresultNotLike(String value) {
            addCriterion("Osresult not like", value, "osresult");
            return (Criteria) this;
        }

        public Criteria andOsresultIn(List<String> values) {
            addCriterion("Osresult in", values, "osresult");
            return (Criteria) this;
        }

        public Criteria andOsresultNotIn(List<String> values) {
            addCriterion("Osresult not in", values, "osresult");
            return (Criteria) this;
        }

        public Criteria andOsresultBetween(String value1, String value2) {
            addCriterion("Osresult between", value1, value2, "osresult");
            return (Criteria) this;
        }

        public Criteria andOsresultNotBetween(String value1, String value2) {
            addCriterion("Osresult not between", value1, value2, "osresult");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("Endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("Endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(String value) {
            addCriterion("Endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(String value) {
            addCriterion("Endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(String value) {
            addCriterion("Endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("Endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(String value) {
            addCriterion("Endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(String value) {
            addCriterion("Endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLike(String value) {
            addCriterion("Endtime like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotLike(String value) {
            addCriterion("Endtime not like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<String> values) {
            addCriterion("Endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<String> values) {
            addCriterion("Endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(String value1, String value2) {
            addCriterion("Endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(String value1, String value2) {
            addCriterion("Endtime not between", value1, value2, "endtime");
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
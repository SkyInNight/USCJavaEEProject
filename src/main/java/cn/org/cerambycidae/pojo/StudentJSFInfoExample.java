package cn.org.cerambycidae.pojo;

import java.util.ArrayList;
import java.util.List;

public class StudentJSFInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentJSFInfoExample() {
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

        public Criteria andStuNumIsNull() {
            addCriterion("stu_Num is null");
            return (Criteria) this;
        }

        public Criteria andStuNumIsNotNull() {
            addCriterion("stu_Num is not null");
            return (Criteria) this;
        }

        public Criteria andStuNumEqualTo(Integer value) {
            addCriterion("stu_Num =", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumNotEqualTo(Integer value) {
            addCriterion("stu_Num <>", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumGreaterThan(Integer value) {
            addCriterion("stu_Num >", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_Num >=", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumLessThan(Integer value) {
            addCriterion("stu_Num <", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumLessThanOrEqualTo(Integer value) {
            addCriterion("stu_Num <=", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumIn(List<Integer> values) {
            addCriterion("stu_Num in", values, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumNotIn(List<Integer> values) {
            addCriterion("stu_Num not in", values, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumBetween(Integer value1, Integer value2) {
            addCriterion("stu_Num between", value1, value2, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_Num not between", value1, value2, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNull() {
            addCriterion("stu_Name is null");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNotNull() {
            addCriterion("stu_Name is not null");
            return (Criteria) this;
        }

        public Criteria andStuNameEqualTo(String value) {
            addCriterion("stu_Name =", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotEqualTo(String value) {
            addCriterion("stu_Name <>", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThan(String value) {
            addCriterion("stu_Name >", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_Name >=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThan(String value) {
            addCriterion("stu_Name <", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThanOrEqualTo(String value) {
            addCriterion("stu_Name <=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLike(String value) {
            addCriterion("stu_Name like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotLike(String value) {
            addCriterion("stu_Name not like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameIn(List<String> values) {
            addCriterion("stu_Name in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotIn(List<String> values) {
            addCriterion("stu_Name not in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameBetween(String value1, String value2) {
            addCriterion("stu_Name between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotBetween(String value1, String value2) {
            addCriterion("stu_Name not between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuTeamnumIsNull() {
            addCriterion("stu_TeamNum is null");
            return (Criteria) this;
        }

        public Criteria andStuTeamnumIsNotNull() {
            addCriterion("stu_TeamNum is not null");
            return (Criteria) this;
        }

        public Criteria andStuTeamnumEqualTo(Integer value) {
            addCriterion("stu_TeamNum =", value, "stuTeamnum");
            return (Criteria) this;
        }

        public Criteria andStuTeamnumNotEqualTo(Integer value) {
            addCriterion("stu_TeamNum <>", value, "stuTeamnum");
            return (Criteria) this;
        }

        public Criteria andStuTeamnumGreaterThan(Integer value) {
            addCriterion("stu_TeamNum >", value, "stuTeamnum");
            return (Criteria) this;
        }

        public Criteria andStuTeamnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_TeamNum >=", value, "stuTeamnum");
            return (Criteria) this;
        }

        public Criteria andStuTeamnumLessThan(Integer value) {
            addCriterion("stu_TeamNum <", value, "stuTeamnum");
            return (Criteria) this;
        }

        public Criteria andStuTeamnumLessThanOrEqualTo(Integer value) {
            addCriterion("stu_TeamNum <=", value, "stuTeamnum");
            return (Criteria) this;
        }

        public Criteria andStuTeamnumIn(List<Integer> values) {
            addCriterion("stu_TeamNum in", values, "stuTeamnum");
            return (Criteria) this;
        }

        public Criteria andStuTeamnumNotIn(List<Integer> values) {
            addCriterion("stu_TeamNum not in", values, "stuTeamnum");
            return (Criteria) this;
        }

        public Criteria andStuTeamnumBetween(Integer value1, Integer value2) {
            addCriterion("stu_TeamNum between", value1, value2, "stuTeamnum");
            return (Criteria) this;
        }

        public Criteria andStuTeamnumNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_TeamNum not between", value1, value2, "stuTeamnum");
            return (Criteria) this;
        }

        public Criteria andStuAgeIsNull() {
            addCriterion("stu_Age is null");
            return (Criteria) this;
        }

        public Criteria andStuAgeIsNotNull() {
            addCriterion("stu_Age is not null");
            return (Criteria) this;
        }

        public Criteria andStuAgeEqualTo(Integer value) {
            addCriterion("stu_Age =", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeNotEqualTo(Integer value) {
            addCriterion("stu_Age <>", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeGreaterThan(Integer value) {
            addCriterion("stu_Age >", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_Age >=", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeLessThan(Integer value) {
            addCriterion("stu_Age <", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeLessThanOrEqualTo(Integer value) {
            addCriterion("stu_Age <=", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeIn(List<Integer> values) {
            addCriterion("stu_Age in", values, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeNotIn(List<Integer> values) {
            addCriterion("stu_Age not in", values, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeBetween(Integer value1, Integer value2) {
            addCriterion("stu_Age between", value1, value2, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_Age not between", value1, value2, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuMajorIsNull() {
            addCriterion("stu_Major is null");
            return (Criteria) this;
        }

        public Criteria andStuMajorIsNotNull() {
            addCriterion("stu_Major is not null");
            return (Criteria) this;
        }

        public Criteria andStuMajorEqualTo(String value) {
            addCriterion("stu_Major =", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotEqualTo(String value) {
            addCriterion("stu_Major <>", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorGreaterThan(String value) {
            addCriterion("stu_Major >", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorGreaterThanOrEqualTo(String value) {
            addCriterion("stu_Major >=", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorLessThan(String value) {
            addCriterion("stu_Major <", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorLessThanOrEqualTo(String value) {
            addCriterion("stu_Major <=", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorLike(String value) {
            addCriterion("stu_Major like", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotLike(String value) {
            addCriterion("stu_Major not like", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorIn(List<String> values) {
            addCriterion("stu_Major in", values, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotIn(List<String> values) {
            addCriterion("stu_Major not in", values, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorBetween(String value1, String value2) {
            addCriterion("stu_Major between", value1, value2, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotBetween(String value1, String value2) {
            addCriterion("stu_Major not between", value1, value2, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuGenderIsNull() {
            addCriterion("stu_Gender is null");
            return (Criteria) this;
        }

        public Criteria andStuGenderIsNotNull() {
            addCriterion("stu_Gender is not null");
            return (Criteria) this;
        }

        public Criteria andStuGenderEqualTo(String value) {
            addCriterion("stu_Gender =", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotEqualTo(String value) {
            addCriterion("stu_Gender <>", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderGreaterThan(String value) {
            addCriterion("stu_Gender >", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderGreaterThanOrEqualTo(String value) {
            addCriterion("stu_Gender >=", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderLessThan(String value) {
            addCriterion("stu_Gender <", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderLessThanOrEqualTo(String value) {
            addCriterion("stu_Gender <=", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderLike(String value) {
            addCriterion("stu_Gender like", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotLike(String value) {
            addCriterion("stu_Gender not like", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderIn(List<String> values) {
            addCriterion("stu_Gender in", values, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotIn(List<String> values) {
            addCriterion("stu_Gender not in", values, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderBetween(String value1, String value2) {
            addCriterion("stu_Gender between", value1, value2, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotBetween(String value1, String value2) {
            addCriterion("stu_Gender not between", value1, value2, "stuGender");
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
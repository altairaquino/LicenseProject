define(["modules/forms/module","ionslider"],function(a){"use strict";return a.registerDirective("smartIonslider",function(){return{restrict:"A",compile:function(a){a.removeAttr("smart-ionslider data-smart-ionslider"),a.ionRangeSlider()}}})});
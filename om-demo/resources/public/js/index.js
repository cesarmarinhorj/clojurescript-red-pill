
this.generateGraph = function(d) {
  c3.generate({
    padding: { left: 25 },
    bindto: '#chart',
    data: {columns: d.columns},
    axis: {
      y: { max: 100, min: 0 },
      x: {
        tick: {
          format: function(d) {
            var label = {0: "D", 1: "I", 2: "S", 3: "C"};
            return label[d];
          }
        }
      }
    }
  });
};

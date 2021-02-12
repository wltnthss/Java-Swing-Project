package Log;

public class TimeDTO {
   
    private int t_number ;
    private String t_program; 
    private String t_start;
    private String t_end ;
    private String t_trainer;
    private int t_max;
    
   public TimeDTO() {
      super();
   }

   public TimeDTO(int t_number, String t_program, String t_start, String t_end, String t_trainer, int t_max) {
      super();
      this.t_number = t_number;
      this.t_program = t_program;
      this.t_start = t_start;
      this.t_end = t_end;
      this.t_trainer = t_trainer;
      this.t_max = t_max;
   }
   
   
   
   @Override
   public String toString() {
      return "TimeDTO [t_number=" + t_number + ", t_program=" + t_program + ", t_start=" + t_start + ", t_end="
            + t_end + ", t_trainer=" + t_trainer + ", t_max=" + t_max + "]";
   }

   public int getT_number() {
      return t_number;
   }

   public void setT_number(int t_number) {
      this.t_number = t_number;
   }

   public String getT_program() {
      return t_program;
   }

   public void setT_program(String t_program) {
      this.t_program = t_program;
   }

   public String getT_start() {
      return t_start;
   }

   public void setT_start(String t_start) {
      this.t_start = t_start;
   }

   public String getT_end() {
      return t_end;
   }

   public void setT_end(String t_end) {
      this.t_end = t_end;
   }

   public String getT_trainer() {
      return t_trainer;
   }

   public void setT_trainer(String t_trainer) {
      this.t_trainer = t_trainer;
   }

   public int getT_max() {
      return t_max;
   }

   public void setT_max(int t_max) {
      this.t_max = t_max;
   }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
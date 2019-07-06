package android.example.truthanddare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    Button button;
    int first=0, last,count=0;
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image=findViewById(R.id.img);
        button=findViewById(R.id.btn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spin();
                count++;
                if(count>0){
                    first=last;
                }
            }
        });
    }
    private void spin(){
        int pivotX=image.getHeight()/3;
        int pivotY=image.getHeight()/3;
        r=new Random();
        int a=r.nextInt(5000);
        last=a;
        Animation rotate = new RotateAnimation(first,last,pivotX,pivotY);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);

        image.startAnimation(rotate);
    }

}

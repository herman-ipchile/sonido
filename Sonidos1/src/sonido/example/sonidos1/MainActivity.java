package sonido.example.sonidos1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	MediaPlayer mepe;
	Button btnLoop;
	int pos = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnLoop = (Button)findViewById(R.id.btnLoop);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void escucharGato(View v){
		
		MediaPlayer mepe = MediaPlayer.create(this, R.raw.gato);
		mepe.start();	
	}
	
	public void destruir(){
		if(mepe !=null){
			mepe.release();
		}
		
	}
	
	public void playCancion(View v){
		destruir();
		mepe= MediaPlayer.create(this, R.raw.tv);
		mepe.start();
		String texto =btnLoop.getText().toString();
		if(texto.equals("No Loop")){
			mepe.setLooping(false);
		}else{
			mepe.setLooping(true);
		}
		
		
	}
	public void pausarCancion(View v){
		if(mepe != null && mepe.isPlaying()){
			pos = mepe.getCurrentPosition();
			mepe.pause();
		}
	}
	public void seguirCancion(View v){
		if(mepe != null && mepe.isPlaying()==false){
			mepe.seekTo(pos);
			mepe.start();
		}
	}
	public void paraCancion(View v){
		if(mepe!=null){
		mepe.stop();
		pos=0;
		}
	}
	public void loopeando(View v){
		
		String texto =btnLoop.getText().toString();
		if(texto.equals("No Loop")){
			btnLoop.setText("Loop");
		}else{
			btnLoop.setText("No Loop");
		}
		
	}
}

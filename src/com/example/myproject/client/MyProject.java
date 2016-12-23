package com.example.myproject.client;

import java.util.Random;

import com.example.myproject.shared.GenRandomNum;
import com.example.myproject.shared.ProgressBar;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MyProject implements EntryPoint {

	private Button btnSetting;
	private Label lblScore;
	private Label lblMath;
	private Button btnRight;
	private Button btnLeft;
	private Button btnStart;
	// private Label lblTime;
	private int score;
	private boolean flag;
	private MyTimer timer;
	private ProgressBar prgBar;
	private GenRandomNum randNum;
	private Random random;
	private Label textSlider;
	private int timeSecond = 10;
	// private long startTime;
	private static final String[] colors = new String[] {"AliceBlue", "AntiqueWhite", "Aqua", "Aquamarine", "Azure", "Beige", "Bisque", "Black", "BlanchedAlmond", "Blue", "BlueViolet", "Brown", "BurlyWood", "CadetBlue", "Chartreuse", "Chocolate", "Coral", "CornflowerBlue", "Cornsilk", "Crimson", "Cyan", "DarkBlue", "DarkCyan", "DarkGoldenRod", "DarkGray", "DarkGrey", "DarkGreen", "DarkKhaki", "DarkMagenta", "DarkOliveGreen", "DarkOrange", "DarkOrchid", "DarkRed", "DarkSalmon", "DarkSeaGreen", "DarkSlateBlue", "DarkSlateGray", "DarkSlateGrey", "DarkTurquoise", "DarkViolet", "DeepPink", "DeepSkyBlue", "DimGray", "DimGrey", "DodgerBlue", "FireBrick", "FloralWhite", "ForestGreen", "Fuchsia", "Gainsboro", "GhostWhite", "Gold", "GoldenRod", "Gray", "Grey", "Green", "GreenYellow", "HoneyDew", "HotPink", "IndianRed ", "Indigo ", "Ivory", "Khaki", "Lavender", "LavenderBlush", "LawnGreen", "LemonChiffon", "LightBlue", "LightCoral", "LightCyan", "LightGoldenRodYellow", "LightGray", "LightGrey", "LightGreen", "LightPink", "LightSalmon", "LightSeaGreen", "LightSkyBlue", "LightSlateGray", "LightSlateGrey", "LightSteelBlue", "LightYellow", "Lime", "LimeGreen", "Linen", "Magenta", "Maroon", "MediumAquaMarine", "MediumBlue", "MediumOrchid", "MediumPurple", "MediumSeaGreen", "MediumSlateBlue", "MediumSpringGreen", "MediumTurquoise", "MediumVioletRed", "MidnightBlue", "MintCream", "MistyRose", "Moccasin", "NavajoWhite", "Navy", "OldLace", "Olive", "OliveDrab", "Orange", "OrangeRed", "Orchid", "PaleGoldenRod", "PaleGreen", "PaleTurquoise", "PaleVioletRed", "PapayaWhip", "PeachPuff", "Peru", "Pink", "Plum", "PowderBlue", "Purple", "RebeccaPurple", "Red", "RosyBrown", "RoyalBlue", "SaddleBrown", "Salmon", "SandyBrown", "SeaGreen", "SeaShell", "Sienna", "Silver", "SkyBlue", "SlateBlue", "SlateGray", "SlateGrey", "Snow", "SpringGreen", "SteelBlue", "Tan", "Teal", "Thistle", "Tomato", "Turquoise", "Violet", "Wheat", "White", "WhiteSmoke", "Yellow", "YellowGreen"};

	public void onModuleLoad() {
		btnSetting = new Button("Cài đặt");
		lblScore = new Label();
		lblMath = new Label();
		btnRight = new Button();
		btnLeft = new Button();
		btnStart = new Button("Bắt đầu");
		// lblTime = new Label();

		// We can add style names to widgets
		btnSetting.addStyleName("btn btn-primary setting");
		lblScore.addStyleName("circle");
		btnRight.addStyleName("btn btn-info btn-lg");
		btnLeft.addStyleName("btn btn-info btn-lg");
		btnStart.addStyleName("btn btn-danger btn-lg");
		
		btnSetting.removeStyleName("gwt-Button");
		btnRight.removeStyleName("gwt-Button");
		btnLeft.removeStyleName("gwt-Button");
		btnStart.removeStyleName("gwt-Button");

		// RootPanel.get("timeLabelContainer").add(lblTime);
		RootPanel.get("scoreLabelContainer").add(btnSetting);
		RootPanel.get("scoreLabelContainer").add(lblScore);
		RootPanel.get("mathLabelContainer").add(lblMath);
		RootPanel.get("rightButtonContainer").add(btnRight);
		RootPanel.get("leftButtonContainer").add(btnLeft);
		RootPanel.get("startButtonContainer").add(btnStart);

		btnStart.setFocus(true);
		btnRight.setVisible(false);
		btnLeft.setVisible(false);

		btnStart.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				startMath();
			}
		});

		btnRight.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (flag) {
					trueBtnClick();
				} else {
					falseBtnClick();
				}
			}
		});

		btnLeft.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (!flag) {
					trueBtnClick();
				} else {
					falseBtnClick();
				}
			}
		});

		final DialogBox dialog = new DialogBox();
		dialog.setText("Cài đặt");
		dialog.setAnimationEnabled(true);
		final Button btnSave = new Button("Lưu lại");
		final Button btnCancel = new Button("Hủy bỏ");
		btnSave.getElement().setId("btnSave");
		btnCancel.getElement().setId("btnCancel");
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.add(btnCancel);
		hPanel.add(btnSave);
		
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.setStyleName("vPanel");
		vPanel.add(new HTML("<b>Cài đặt thời gian trả lời</b>"));
		vPanel.add(new HTML("<input id='rangeSlider' type='range' min='1' max='100' step='1' value='10' onchange=\"printValue('rangeSlider', 'textSlider')\" />"));
		textSlider = new Label("1.0 giây");
		textSlider.getElement().setAttribute("id", "textSlider");
		vPanel.add(textSlider);
		vPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		vPanel.add(hPanel);
		
		dialog.setWidget(vPanel);
		
		btnSetting.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialog.center();
			}
		});
		
		btnCancel.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialog.hide();
			}
		});
		
		btnSave.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String timeLabel = textSlider.getText();
				double timeValue = Double.parseDouble(timeLabel.split(" ")[0]);
				timeSecond = (int) (timeValue * 10);
				dialog.hide();
			}
		});
		
		prgBar = new ProgressBar(100);
		prgBar.addStyleName("progressbar-solid progressbar-noborder");
		timer = new MyTimer();
		randNum = new GenRandomNum();
		random = new Random();
	}

	private void startMath() {
		btnStart.setVisible(false);
		score = 0;

		displayMath();
	}

	private void trueBtnClick() {
		score++;
		
		displayMath();
	}

	private void falseBtnClick() {
		btnRight.setVisible(false);
		btnLeft.setVisible(false);
		lblMath.setText("Bạn được " + score + " điểm");
		// lblTime.setText("");
		btnStart.setVisible(true);
		if (timer.isRunning()) {
			timer.cancel();
		}
		RootPanel.get("timeLabelContainer").clear();
	}

	private void displayMath() {
		btnRight.setVisible(true);
		btnLeft.setVisible(true);

		randNum.setMathExpression(score);
		this.flag = random.nextBoolean();
		lblMath.setText(randNum.getExpression());
		if (flag) {
			btnRight.setText(randNum.getTrueResult());
			btnLeft.setText(randNum.getFalseResult());
		} else {
			btnRight.setText(randNum.getFalseResult());
			btnLeft.setText(randNum.getTrueResult());
		}

		int index = random.nextInt(colors.length);
		lblScore.setText(score + "");
		lblScore.getElement().getStyle().setProperty("background", colors[index]);
		prgBar.setProgress(100);
		// startTime = System.currentTimeMillis();
		RootPanel.get("timeLabelContainer").add(prgBar);
		// timer.setSecond(15); // set 15 * 100 millisecond below is total 1.5
		// second
		timer.schedule(10);
	}

	private class MyTimer extends Timer {

		// int second;

		public void run() {
			// lblTime.setText(second-- / (10.0) + "");
			int progress = prgBar.getProgress() - 1;
			if (progress < 0) {
				progress = 0;
				falseBtnClick();
			}
			prgBar.setProgress(progress);
			// prgBar.setText("" + (System.currentTimeMillis() - startTime));
			if (progress >= 0) {
				schedule(timeSecond);
			}
		}

		// public void setSecond(int second) {
		// this.second = second;
		// }
	}
}
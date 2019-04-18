//package es.rchampa.mapearimagen;
//
//import android.view.ScaleGestureDetector;
//
//public class MyScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
//    @Override
//    public boolean onScaleBegin(ScaleGestureDetector detector) {
//        return true;
//    }
//
//    @Override
//    public boolean onScale(ScaleGestureDetector detector) {
//        scaleImage(detector.getScaleFactor(), detector.getFocusX(), detector.getFocusY(), true);
//
//        //
//        // OnTouchImageViewListener is set: TouchImageView pinch zoomed by user.
//        //
//        if (touchImageViewListener != null) {
//            touchImageViewListener.onMove();
//        }
//        return true;
//    }
//
//    @Override
//    public void onScaleEnd(ScaleGestureDetector detector) {
//        super.onScaleEnd(detector);
//        setState(TouchImageView.State.NONE);
//        boolean animateToZoomBoundary = false;
//        float targetZoom = normalizedScale;
//        if (normalizedScale > maxScale) {
//            targetZoom = maxScale;
//            animateToZoomBoundary = true;
//
//        } else if (normalizedScale < minScale) {
//            targetZoom = minScale;
//            animateToZoomBoundary = true;
//        }
//
//        if (animateToZoomBoundary) {
//            TouchImageView.DoubleTapZoom doubleTap = new TouchImageView.DoubleTapZoom(targetZoom, viewWidth / 2, viewHeight / 2, true);
//            compatPostOnAnimation(doubleTap);
//        }
//    }
//
//
//}